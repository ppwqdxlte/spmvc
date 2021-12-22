package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

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
