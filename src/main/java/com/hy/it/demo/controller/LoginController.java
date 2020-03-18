package com.hy.it.demo.controller;

import com.hy.it.demo.entity.User;
import com.hy.it.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private IUserService userService;
    @PostMapping(value = "/loginValidate")
    public ModelAndView testThymeleaf(@RequestParam("userName") String username, @RequestParam("password") String password, Map<String,Object> map,
                                      HttpSession httpSession){

        User user=userService.queryUser(username,password);
        if(user!=null){
            httpSession.setAttribute("admin",username);
            System.out.println(username+"==========="+password);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");
            return modelAndView;
        }else {
            httpSession.invalidate();
            map.put("msg","用户名密码错误");
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login1");
            return modelAndView;
        }
    }

    @RequestMapping("/loginPage")
    public ModelAndView login(HttpServletRequest request, HttpSession httpSession) {
        String userName = "admin";
        httpSession.setAttribute("admin",userName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login1");
        return modelAndView;
    }
    @RequestMapping("/deparment")
    public ModelAndView deparment() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deparment");
        return modelAndView;
    }

}