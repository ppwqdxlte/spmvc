package com.laowang.resolver;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class MyView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("render.............."+model);
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>测试自建的视图解析器<h1>");
        writer.write("举头望明月<br>我要买个房<br>");
    }
}
