package com.laowang.resolver;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/*
* springmvc.xml中已经使用了 InternalResourceViewResolver，
* 拦截器和过滤器都有链式传递，视图解析器也有个链，一种Resolver解析器搭配一种View视图实现类使用，层层渲染，我觉得view可能是用包装模式逐层渲染的，
* 所有视图解析器都走了一遍
* 在xml之中就用<propertie name="order">N 来表示优先级，N越大越靠后，N越小越靠前，
* 所以为了测试本自定义视图解析器，将此类注解为@Order(1)
* */

@Component
@Order(1)
public class MyViewResolver implements ViewResolver, Ordered {

    /*
    * 配置xml可以自定义属性【类变量】，并设置setter方法，xml里面的property value是从setter方法注入的
    * */
    private int order;

    public void setOrder(int order){
        this.order = order;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        System.out.println("resolveViewName......................");
        if (viewName.startsWith("laowang:")){
            System.out.println("viewName is:--->"+ viewName);
            return new MyView();
        }else{
            return null;//返回空表示接着往后面的ViewResolver传递
        }
    }
}
