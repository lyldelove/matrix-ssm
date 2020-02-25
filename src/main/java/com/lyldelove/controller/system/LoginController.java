package com.lyldelove.controller.system;

import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println(1);
        SysUser sysUser = sysUserService.getUser();
        System.out.println(sysUser.getUserName());
        return "login";
    }
}
