package com.lyldelove.controller.system;

import com.lyldelove.base.system.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    /**
     * GET请求的/login，跳转到登录界面
     * @return login.html
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * POST请求的/login，登录界面的表单提交
     * @param username 用户名
     * @param password 密码
     * @param rememberMe 记住我
     * @return 通用返回结果集Result
     */
    @PostMapping("/login")
    @ResponseBody
    public Result signIn(String username, String password, Boolean rememberMe) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);

        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        return null;
    }

}
