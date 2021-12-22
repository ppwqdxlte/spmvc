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
    <title>HOME PAGE</title>
  </head>
  <body>
  欢迎来到---首页

  <% pageContext.setAttribute("ctp",request.getContextPath());%>

  <form action="${ctp}/user/1" method="post">
      <input type="hidden" name="id" value="1"><%--隐藏域，写死id=1 --%><br>
      姓名：<input type="text" name="name"><br>
      年龄：<input type="text" name="age"><br>
      密码：<input type="password" name="password"><br>
      <input type="submit" value="更 新"><br>
  </form>
  
  <br>
  <br>
  <img src="${ctp}/static/images/shenzhen.jpg" alt="找不到？咋回事儿！"/>

  </body>
</html>
