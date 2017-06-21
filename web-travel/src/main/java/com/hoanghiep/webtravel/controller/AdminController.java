package com.hoanghiep.webtravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hoanghiep on 12/06/2017.
 */
@Controller
public class AdminController {

//    @RequestMapping("/login")
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("title", "Login - Admin");
        return mav;
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("title", "Đăng ký - Quản trị");
        return mav;
    }

}
