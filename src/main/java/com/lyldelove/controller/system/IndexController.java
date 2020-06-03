package com.lyldelove.controller.system;

import com.lyldelove.controller.BaseController;
import com.lyldelove.dto.system.Menu;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.intf.system.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController extends BaseController {

    @Resource
    private MenuService menuService;

    /**
     * GET请求的/index，跳转到index.html
     * @return index.html
     */
    @GetMapping("/index")
    public String login(ModelMap modelMap) {
        //获取当前用户信息
        SysUser sysUser = getSysUser();
        //根据用户ID获取用户的权限菜单信息
        List<Menu> menus = menuService.selectMenuByUser(sysUser);

        modelMap.put("menus", menus);
        modelMap.put("user", sysUser);

        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main() {
        return "main";
    }
}
