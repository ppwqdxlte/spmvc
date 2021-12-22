<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/20
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <% pageContext.setAttribute("ctp",request.getContextPath());%>
  <body>
    <form action="${ctp}/hello/world" method="post">
      <input type="text" name="username"/>
      <input type="submit"/>
    </form>
  $END$
  </body>
</html>
