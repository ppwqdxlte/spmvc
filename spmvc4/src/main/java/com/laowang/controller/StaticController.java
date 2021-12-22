package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 静态资源的访问：
*
* */
@Controller
@RequestMapping("/stat")
public class StaticController {

    /*
    * images图片文件夹放在web根目录下，就能访问到里面的图片，但是放在/WEB-INF/目录里是受保护的状态，无法直接从URL请求到受保护的静态资源！
    * 【问题】那么怎么请求受保护的资源呢？
    *           <mvc:resources mapping="/static/**" location="/WEB-INF/static/" /> 略略略。。。
    * */
    @RequestMapping("/1")
    public String static1(){
        System.out.println("static1..................");
        return "forward:/index.jsp";
    }

}
