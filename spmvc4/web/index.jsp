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
  </form><br><br>

  请按照id-name-age-password 的方式输入数据：<br>
  <form action="${ctp}/converter/1" method="post">
      <%--
      要想成功映射，下面输入框的属性名称必须要和controller的方法入参名称user保持一致！
      这样 MyConverter才能正确转换注入！
      --%>
      <input type="text" name="user"><br>
      <input type="submit" value="提交">
  </form><br><br>

  自定义日期格式转换器：<br>
  <form action="${ctp}/dateconvert/1" method="post">
      id:<input type="text" name="id" value="${dateUser.id}"><br>
      name:<input type="text" name="name" value="${dateUser.name}"><br>
      age:<input type="text" name="age" value="${dateUser.age}"><br>
      password:<input type="password" name="password" value="${dateUser.password}"><br>
      birth:<input type="text" name="birth" value="${dateUser.birth}"><br>
      <input type="submit" value="提交">
  </form>
  
  <br><br><img src="${ctp}/static/images/shenzhen.jpg" alt="找不到？咋回事儿！"/>

  </body>
</html>
