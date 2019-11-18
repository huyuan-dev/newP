package com.hy.it.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录controller
 */
@RestController
@RequestMapping(value = "loginIn")
public class LoginController {
    @GetMapping(value = "/login")
    public String longin(){
        return "hello huyuan";
    }
}
