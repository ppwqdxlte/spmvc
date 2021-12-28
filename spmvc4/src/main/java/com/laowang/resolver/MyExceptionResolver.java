package com.laowang.resolver;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*全局异常处理切面
* 这种控制器切面，异常处理可以写在Controller外面，统一异常处理
* 但是你要注意了： SpringMVC 异常处理器分三类，ExceptionHandler，ResponseStatus，和DefaultException，
* 就是说实现了此HandlerExceptionResolver接口的处理类只能处理 Exception，不能处理ResponseStatus异常，要处理后者用别的方法
* */
@ControllerAdvice
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println(this.getClass().getName()+": resolveException==::  "+ex.getLocalizedMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("exce",ex);
        return modelAndView;
    }

    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public ModelAndView resolveArithmeticAndNullPointEx(Exception ex){
        System.out.println(this.getClass().getName()+": resolveArithmeticAndNullPointEx==::  "+ex.getLocalizedMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("exce",ex);
        return modelAndView;
    }
}
