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
    <title>USER PAGE</title>
  </head>
  <body>

  <% pageContext.setAttribute("ctp",request.getContextPath());%>

  <form action="${ctp}/user/1" method="post">
    <input type="hidden" name="id" value="1"><%--隐藏域，写死id=1 --%><br>
    姓名：王五<%--<input type="text" name="name" value="${user.name}">--%><br>
    年龄：<input type="text" name="age" value="${user.age}"><br>
    密码：<input type="password" name="password" value="${user.password}"><br>
    <input type="submit" value="更 新"><br>
  </form>

  </body>
</html>
