package com.hy.it.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/thymeleafTest")
public class LoginController {
    @RequestMapping("/testThymeleaf")
    public ModelAndView testThymeleaf(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("user","login");
        modelAndView.setViewName("login.html");
        return modelAndView;
    }
}