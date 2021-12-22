package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 定向就会重新发起请求，可以通过F12验证，地址栏也会变化
* 【注意】重定向后续也不会经过视图解析器！
* 根目录：不包含项目名称！！！从浏览器端跳转！2次请求！请求域数据会丢失！
* */
@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @RequestMapping("/1")
    public String redirect1(){
        System.out.println("redirect1-------");
        return "redirect:/index.jsp";
    }

    @RequestMapping("/2")
    public String redirect2(){
        System.out.println("redirect2--------");
        return "redirect:/redirect/1";
    }
}
