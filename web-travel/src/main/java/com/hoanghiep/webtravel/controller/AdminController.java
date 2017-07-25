package com.hoanghiep.webtravel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hoanghiep on 12/06/2017.
 */
@Controller
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/login")
    public ModelAndView login(Authentication auth){
        logger.info("auth name: {}", auth.getPrincipal());

        ModelAndView mav = new ModelAndView("login");
        mav.addObject("title", "Login - Admin");
        return mav;
    }

    @GetMapping(value = "/register", produces = "text/plain;charset=UTF-8")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("title", "Đăng ký - Quản trị");
        mav.addObject("resources", "/js/signup.js");
        return mav;
    }

}
