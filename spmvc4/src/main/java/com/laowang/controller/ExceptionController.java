package com.laowang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/1")
    public String exception1(){
        int i = 10/0;
        return "success";
    }

    @RequestMapping("/2")
    public String exception2(String username) throws UsernameException{
        if (username == null || username.isEmpty()){
            throw new UsernameException("There's no parameter of 'username'");
        }
        return "success";
    }

    /*
    * 类似这种注解只能处理本类内部的异常，且异常处理从小到大命中
    * */
    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView handleArithmeticException(ArithmeticException e){
        System.out.println(this.getClass().getName()+": handleArithmeticEx: ");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("exce",e);
        return modelAndView;
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView handleNullPointerException(NullPointerException e){
        System.out.println(this.getClass().getName()+": handleNullPointEx: ");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("exce",e);
        return modelAndView;
    }

    /*
    * 内部异常处理方法 优先级 大于外部异常处理切面！！！注释掉这个方法，才能命中外部切面
    * */
    /*@ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception e){
        System.out.println(this.getClass().getName()+": handleEx: ");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("exce",e);
        return modelAndView;
    }*/
}

class UsernameException extends RuntimeException {

    public UsernameException(String s) {
        super(s);
    }
}
