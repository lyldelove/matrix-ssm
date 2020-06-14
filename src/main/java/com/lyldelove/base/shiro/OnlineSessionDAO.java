package com.lyldelove.base.shiro;

import com.lyldelove.base.async.AsyncFactory;
import com.lyldelove.base.async.AsyncManager;
import com.lyldelove.common.util.StringUtil;
import com.lyldelove.dto.system.OnlineSession;
import com.lyldelove.entity.system.SysUserOnline;
import com.lyldelove.service.intf.system.OnlineService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lyldelove
 * @title OnlineSessionDAO
 * @date 2020/6/10 6:41
 */

public class OnlineSessionDAO extends EnterpriseCacheSessionDAO {

    /**
     * 同步session到数据库的周期 单位为毫秒（默认1分钟）
     */
    @Value("${shiro.session.dbSyncPeriod}")
    private int dbSyncPeriod;

    /**
     * 上次同步数据库的时间戳
     */
    private static final String LAST_SYNC_DB_TIMESTAMP = OnlineSessionDAO.class.getName() + "LAST_SYNC_DB_TIMESTAMP";

    @Resource
    private OnlineService onlineService;

    @Resource
    private OnlineSessionFactory onlineSessionFactory;

    public OnlineSessionDAO() {
        super();
    }

    public OnlineSessionDAO(long expireTime) {
        super();
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        SysUserOnline userOnline = onlineService.selectOnlineById(sessionId + "");

        if (StringUtil.isNull(userOnline)) {
            return null;
        }

        return onlineSessionFactory.createSession(userOnline);
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        super.update(session);
    }

    /**
     * 当会话过期/停止（如用户退出时）属性等会调用
     * @param session
     */
    @Override
    protected void doDelete(Session session) {
        OnlineSession onlineSession = (OnlineSession) session;
        if (StringUtil.isNull(onlineSession)) {
            return;
        }
        onlineSession.setStatus(OnlineSession.OnlineStatus.off_line);
        onlineService.deleteOnlineById(onlineSession.getId() + "");
    }

    /**
     * 更新会话；如更新会话最后访问时间/停止会话/设置超时时间/设置移除属性等会调用
     * @param onlineSession
     */
    public void syncToDb(OnlineSession onlineSession){
        Date lastSyncTimestamp = (Date) onlineSession.getAttribute(LAST_SYNC_DB_TIMESTAMP);

        if (StringUtil.isNotNull(lastSyncTimestamp)) {
            boolean needSync = true;
            long deltaTime = onlineSession.getLastAccessTime().getTime() - lastSyncTimestamp.getTime();

            if (deltaTime < dbSyncPeriod * 60 * 1000) {
                // 时间差不足 无需同步
                needSync = false;
            }

            // isGuest = true 访客
            boolean isGuest = onlineSession.getUserId() == null || onlineSession.getUserId() == 0L;

            // session 数据变更了 同步
            if (!isGuest && onlineSession.isAttributeChanged()) {
                needSync = true;
            }

            if (!needSync) {
                return;
            }

            // 更新上次同步数据库时间
            onlineSession.setAttribute(LAST_SYNC_DB_TIMESTAMP, onlineSession.getLastAccessTime());

            // 更新完后 重置标识
            if (onlineSession.isAttributeChanged()) {
                onlineSession.resetAttributeChanged();
            }

            // 保存至数据库
            AsyncManager.getManager().execute(AsyncFactory.syncSessionToDb(onlineSession));
        }

    }
}
