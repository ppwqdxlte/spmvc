<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/22
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  </body>
</html>
