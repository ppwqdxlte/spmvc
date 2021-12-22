package com.laowang.filter;

import javax.servlet.*;
import java.io.IOException;


/*
* 过滤器说白了也是一种servlet，所以要在web.xml里配置过滤器的servlet！！！
* TODO: 中文乱码依然没有解决
* */
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("user--------start:");
        //控制台中文乱码，尚未解决
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("user--------stop.");
    }
}
