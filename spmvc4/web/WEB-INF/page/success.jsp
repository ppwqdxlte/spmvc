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
  application:${applicationScope.hello}<br>

  </body>
</html>
