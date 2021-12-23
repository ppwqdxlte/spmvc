package com.laowang.controller;

import com.laowang.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dateconvert")
public class DateConverterController {

    @RequestMapping("/1")
    public String dateConvert1(User user, Model model){
        System.out.println(user);
        model.addAttribute("dateUser",user);
        return "forward:/index.jsp";
    }
}
