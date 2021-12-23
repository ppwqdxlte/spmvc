<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/23
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请登录</title>
</head>
<body>
<% pageContext.setAttribute("ctp",request.getContextPath());%>
  <form action="${ctp}/validate/1" method="post">
      ID:<input type="text" name="id" value="${person.id}">${errors.id}<br>
      name:<input type="text" name="name" value="${person.name}">${errors.name}<br>
      age:<input type="text" name="age" value="${person.age}">${errors.age}<br>
      birth:<input type="text" name="birth" value="${person.birth}">${errors.birth}<br><%--注意轻易别用date组件！容易报错！--%>
      phoneNum:<input type="text" name="phoneNum" value="${person.phoneNum}">${errors.phoneNum}<br>
      email:<input type="text" name="email" value="${person.email}">${errors.email}<br>
      <input type="submit" value="登陆">
  </form>

</body>
</html>
