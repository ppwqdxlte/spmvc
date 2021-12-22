package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/*
 * JSP 页面有几种作用域？？有几种内置对象？
 *  【答】9大内置对象，4大作用域
 *  四个作用域：
 *   page:           当前页面
 *   request:        当前请求
 *   session:        当前会话
 *   application:    当前应用
 *  【注意】当使用Map，Model，ModelMap，ModelAndView
 *          传递数据的时候，数据被放在requestScope作用域中！！
 *  通过看 DispatcherServlet doDispatcher()方法可知，载体都会转化为ModelAndView 对象
 *  有时候需要往其他作用域传数据，比如用户信息放在session中时候：
 *         在类名上面加个注解@SessionScope
 *          value表示要存储在session域中的属性，types表示要存在session中的类型，两个属性取并集，
 *          且属性先要存在request scope 里面，然后再放进 session scope里面！~
 *  【注意】尽量别用type属性！否则session域会保存很多不必要的东西！
 * */
@Controller
@RequestMapping("/output")
@SessionAttributes(value = {"username"},types = {Integer.class,Map.class})
public class OutputController {

    @RequestMapping("/5")
    public String output5(Model model){
        model.addAttribute("username","LaoWang");
        return "success";
    }

    @RequestMapping("/1")
    public String output1(Map<String,String> map){
        map.put("hello","我的乐园！！~~");
        System.out.println(map.getClass());//class org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    @RequestMapping("/2")
    public String output2(Model model){
        model.addAttribute("hello","我的王国！！~~~~");
        System.out.println(model.getClass());//class org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    @RequestMapping("/3")
    public String output3(ModelMap modelMap){
        modelMap.addAttribute("hello","我的理想国！！！~~~~~~~");
        System.out.println(modelMap.getClass());//class org.springframework.validation.support.BindingAwareModelMap
        return "success";
    }

    @RequestMapping("/4")
    public ModelAndView output4(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("hello","我的祖国！！！！~~~~~~~~~~~~");
        return mv;
    }
}