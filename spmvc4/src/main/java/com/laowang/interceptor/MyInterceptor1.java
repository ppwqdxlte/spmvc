package com.laowang.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 拦截器依赖于servlet，也就是说Interceptor依赖于SpringMVC，所以必须在springmvc。xml中配置bean，注册到容器中
 */
public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * controller目标方法之前执行
     * @param request 请求
     * @param response 响应
     * @param handler 拦截处理器
     * @return 知否继续，false终止，true继续后面的操作
     * @throws Exception 拦截过程中可能会出现异常，异常的话请求就没响应了
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle.....1.......");
        return true;
    }

    /**
     * 目标方法执行完再执行此拦截方法，在return ModelandView 前执行，可以修改返回值，起到增强器的作用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle......1.....");
    }

    /**
     * return 后执行，且在返回jsp页面后执行，当前这个拦截器对于此次action请求就finish了，剩下的事儿交给其它拦截器和过滤器等等
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion.......1........");
    }
}
