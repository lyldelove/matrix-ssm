package com.lyldelove.controller.system;

import com.lyldelove.controller.BaseController;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.intf.system.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

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
        //根据用户ID获取权限菜单信息


        return "index";
    }
}
