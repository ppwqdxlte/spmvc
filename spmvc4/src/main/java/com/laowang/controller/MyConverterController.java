package com.laowang.controller;

import com.laowang.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/converter")
public class MyConverterController {

    /*
    * 前端页面的input标签name属性值，必须和次控制方法参数名user保持一致，
    * 否则注入不进去！自定义转换器注入过程中要找到映射才能正确转换！！
    * */
    @RequestMapping("/1")
    public String testConverter1(User user, Model model){
        System.out.println(user);
        model.addAttribute("convertedUser",user);
        return "success";
    }
}
