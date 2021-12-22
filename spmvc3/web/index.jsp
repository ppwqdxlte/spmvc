<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/21
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <% pageContext.setAttribute("ctp",request.getContextPath());%>
  <body>
    <form action="${ctp}/ucr/user" method="post">
      <input type="text" placeholder="ID" name="id"/>
      <input type="text" placeholder="name" name="name"/>
      <input type="submit" value="新增"/>
    </form>


    <form action="${ctp}/ucr/user" method="post">
      <input type="hidden" name="_method" value="delete"/>
      <input type="submit" value="删除">
    </form>

    <form action="${ctp}/ucr/user" method="post">
      <input type="hidden" name="_method" value="put"/>
      <input type="submit" value="更新">
    </form>

    <a href="${ctp}/ucr/user">查询</a>

    <form action="${ctp}/ucr/user" method="get">
      <input type="submit" value="查询"/>
    </form>

    <div style="border-color: #916dff;border-width: 3px;padding: 10px;">
      <form action="${ctp}/user2/test1" method="post">
        编号：<input type="text" name="id">
        姓名：<input type="text" name="name">
        年龄：<input type="text" name="age">
        性别：<input type="text" name="gender">
        省份：<input type="text" name="address.province">
        城市：<input type="text" name="address.city">
        区域：<input type="text" name="address.town">
        <input type="submit" value="提交">
      </form>
    </div>
    $END$
  </body>
</html>
