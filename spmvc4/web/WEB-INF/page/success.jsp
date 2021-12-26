<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/22
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% pageContext.setAttribute("ctp",request.getContextPath());%>
<html>
  <head>
    <title>SUCCESS!</title>
  </head>
  <body>

  欢迎来到<br>
  ${hello}<br><br>

  page:${pageScope.hello}<br>
  request:${requestScope.hello}<br>
  session:${sessionScope.hello}<br>
  application:${applicationScope.hello}<br><br>

  测试@SessionAttributes注解<br>
  request:${requestScope.username}<br>
  session:${sessionScope.username}<br><br>

  自定义的转换器，将字符串数据转换成user对象：<br>
  id:${convertedUser.id}<br>
  name:${convertedUser.name}<br>
  age:${convertedUser.age}<br>
  password:${convertedUser.password}<br><br>

  <% System.out.println("THIS IS SUCCESS.JSP.");%>

  国际化：<br>
  <h4><a href="${ctp}/i18n/2?locale=zh-CN">中文</a>
    <a href="${ctp}/i18n/2?locale=en-US">ENGLISH</a> </h4>
  <h3><fmt:bundle basename="login">   <%--奇了怪了，必须添加fmt:bundle才能识别出来--%>
    <fmt:message key="welcomeinfo"/></fmt:bundle></h3>
  <form action="${ctp}/i18n/1" method="post">
    <fmt:bundle basename="login"><fmt:message key="username"/></fmt:bundle>:<input type="text" name="name"/><br>
    <fmt:bundle basename="login"><fmt:message key="password"/></fmt:bundle>:<input type="password" name="password"/><br>
    <input type="submit" value="<fmt:bundle basename="login"><fmt:message key="submit"/></fmt:bundle>"/>
  </form>

  </body>
</html>
