package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forward")
public class ForwardController {

    /* 在使用转发的时候必须加上forward:的前缀，
    【注意！！因为】forward请求不经过视图解析器InternalResourceViewResolver，所以必须带上前后缀，所以 .jsp这些不能少！
    根目录：包含项目名称！从服务器跳转，请求域数据不会丢失！地址栏不变，有且只有一次请求！
    * */
    @RequestMapping("/1")
    public String forward1(){
        System.out.println("forward1----------");
        return "forward:/index.jsp";
    }

    /* 转发给其它方法
    * */
    @RequestMapping("/2")
    public String forward2(){
        System.out.println("forward2-----------");
        return "forward:/forward/1";
    }
}
