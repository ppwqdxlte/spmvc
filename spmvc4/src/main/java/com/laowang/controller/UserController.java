package com.laowang.controller;

import com.laowang.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/*
*  * @ModelAttribute只要有这个注解，请求到Controller类的任意方法前，都会执行一次@ModelAttributes注解过的方法
*
* */
@Controller
@RequestMapping("/user")
public class UserController {

    Object o1 = null;
    Object o2 = null;

    Model m1 = null;

    /*
    * User对象自动接收了表单提交的请求数据
    * */
    @RequestMapping("/1")
    public String test1(@ModelAttribute("user") User user){
        System.out.println("test1------------------------------");
        System.out.println(user);
        o2 = user;
        System.out.println("o1 == o2 ????  "+(o1 == o2));
        return "userpage";
    }

    /*
    照样赋值给了模型属性user
    * */
    @ModelAttribute("user")
    public User testModelAttribute2(){
        System.out.println("testModelAttribute2----------------------------");
        User user = new User(1,"Yadianna",21,"awemofiwnoi");
        return user;
    }

    /*
    * 模型属性user1
    * */
    @ModelAttribute
    public void testModelAttribute(Model model){
        System.out.println("testModelAttribute---------------------------");
        User user = new User(2,"LaoWang",21,"123456789");
        model.addAttribute("user1",user);
        o1 = user;
        m1 = model;
    }

    /*
    * 输出结果还是 ModelAttribute默认值，因为 “干”请求/user/2而不是submit的话，是无法传递表单数据的，
    * 所以必须通过表单的提交按钮，既然没有user数据，那么就用到了@ModelAttribute设置的默认值
    * */
    @RequestMapping("/2")
    public String test2(Model model){
        System.out.println("test2---------------------------");
        System.out.println("model == m1 ?????????   "+(model == m1));
        return "userpage";
    }

}
