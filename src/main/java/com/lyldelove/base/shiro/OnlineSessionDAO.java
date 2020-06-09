package com.lyldelove.base.shiro;

import com.lyldelove.common.util.StringUtil;
import com.lyldelove.dto.system.OnlineSession;
import com.lyldelove.entity.system.SysUserOnline;
import com.lyldelove.service.intf.system.OnlineService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author lyldelove
 * @title OnlineSessionDAO
 * @date 2020/6/10 6:41
 */
public class OnlineSessionDAO extends EnterpriseCacheSessionDAO {

    @Resource
    private OnlineService onlineService;

    @Resource
    private OnlineSessionFactory onlineSessionFactory;

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

    public void syncToDb(OnlineSession onlineSession){

    }
}
