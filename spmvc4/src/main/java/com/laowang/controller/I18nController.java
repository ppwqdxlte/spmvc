package com.laowang.controller;

import com.laowang.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/i18n")
public class I18nController {

    @RequestMapping("/1")
    public String i18n1(User user){
        System.out.println("i18n 1 controller......");
        System.out.println(user);
        return "forward:/login.jsp";
    }
}
