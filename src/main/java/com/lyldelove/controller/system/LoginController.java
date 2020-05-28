package com.lyldelove.controller.system;

import com.lyldelove.base.system.Result;
import com.lyldelove.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.lyldelove.base.system.Result.success;

@Controller
public class LoginController extends BaseController {

    /**
     * GET请求的/login，跳转到登录界面
     * @return login.html
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * POST请求的/login，登录界面的表单提交，异常交由全局异常处理
     * @param username 用户名
     * @param password 密码
     * @param rememberMe 记住我
     * @return 通用返回结果集Result
     */
    @PostMapping("/login")
    @ResponseBody
    public Result signIn(String username, String password, Boolean rememberMe) throws AuthenticationException {
        //开启rememberMe功能
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);

        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        return success();
    }

}
