package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


/*
 * JSP 页面有几种作用域？？有几种内置对象？
 *  【答】9大内置对象，4大作用域
 *  四个作用域：
 *   page:           当前页面
 *   request:        当前请求
 *   session:        当前会话
 *   application:    当前应用
 *  【注意】当使用Map\Model\ModelMap传递数据的时候，数据被放在requestScope作用域中！！
 * */
@Controller
@RequestMapping("/output")
public class OutputController {

    @RequestMapping("/1")
    public String output1(Map<String,String> map){
        map.put("hello","我的乐园！！~~");
        return "success";
    }

    @RequestMapping("/2")
    public String output2(Model model){
        model.addAttribute("hello","我的王国！！~~~~");
        return "success";
    }

    @RequestMapping("/3")
    public String output3(ModelMap modelMap){
        modelMap.addAttribute("hello","我的理想国！！！~~~~~~~");
        return "success";
    }
}
