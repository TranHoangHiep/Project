package com.hoanghiep.webtravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hoanghiep on 6/11/17.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Hiep");
        return mav;
    }
}
