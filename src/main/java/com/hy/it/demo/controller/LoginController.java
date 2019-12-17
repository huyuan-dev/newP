package com.hy.it.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {
    @GetMapping(value = "/loginValidate")
    public ModelAndView testThymeleaf() {
        ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");
            return modelAndView;

    }

    @RequestMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            return modelAndView;
    }
}