package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class LoginController {

    // @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, String> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            map.put("message", "用户名密码错误！");
            return "login";
        }
    }
}
