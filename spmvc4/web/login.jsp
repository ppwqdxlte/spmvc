<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/23
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--引入JSP标准标签库 JSTL 的 fmt子库--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--jsp的页面属性变量，一定要设置在 ${“变量”}引用的上面！！！否则找不到变量值！！！--%>
<% pageContext.setAttribute("ctp",request.getContextPath());%>
<html>
<head>
    <title>请登录</title>
    <%--我了个大去！！pageContext.setAttribute("ctp",request.getContextPath());
         一定要定义在  ${ctp}引用的上方！！！之前写在了js引用的下方，结果浏览器F12请求js给我报了个404错误！
    --%>
    <script type="text/javascript" src="${ctp}/static/js/jquery-3.6.0.min.js"></script>
</head>
<body>

Hibernate-validator表单验证：<br>
  <form action="${ctp}/validate/1" method="post">
      ID:<input type="text" name="id" value="${person.id}">${errors.id}<br>
      name:<input type="text" name="name" value="${person.name}">${errors.name}<br>
      age:<input type="text" name="age" value="${person.age}">${errors.age}<br>
      birth:<input type="text" name="birth" value="${person.birth}">${errors.birth}<br><%--注意轻易别用date组件！容易报错！--%>
      phoneNum:<input type="text" name="phoneNum" value="${person.phoneNum}">${errors.phoneNum}<br>
      email:<input type="text" name="email" value="${person.email}">${errors.email}<br>
      <input type="submit" value="登陆">
  </form><br><br>

    <%--哪怕单击事件有url参数值，超链标签的href也要写！--%>
    <h3><a href="#">Ajax请求后台json数据并回显</a></h3>
    <div></div><br>

    <h3><a href="#">Ajax向后台发送json数据</a></h3><br>

    <%--把前端数据保存给HttpEntity<?>参数，
    而不用@RequestParam @RequestAttribute @RequestHeader @RequestBody @PathVariable @CookieValue等注解,
    【注意】HttpEntity不能保存GET方法发送的数据，却能保存POST方法发送的数据，
    就是说不能通过地址栏 ？XXX=XXX & YYY=YYY这样，表单等POST方式都行--%>
    用HttpEntity 控制器方法 参数 来携带前端数据：<br>
    <form action="${ctp}/entity/1" method="post">
        username:<input type="text" name="username" value="${username}"><br>
        age:<input type="text" name="age" value="${age}"><br>
        file:<input type="file" name="file" value="${file}"><br>
        <input type="submit" value="提交">
    </form><br>

    <h3><a href="${ctp}/file/download/1">点击下载jquery.js文件</a></h3><br>

    文件上传：<br>
    <form action="${ctp}/file/upload/1" method="post" enctype="multipart/form-data">
        desc:<input type="text" name="desc"><br>
        file:<input type="file" name="uploadedFile"><br>
        <input type="submit" value="开始上传">
    </form>

    多文件上传：<br>
    <form action="${ctp}/file/upload/2" method="post" enctype="multipart/form-data">
        desc:<input type="text" name="desc"><br>
        file:<input type="file" name="uploadedFile"><br>
        file:<input type="file" name="uploadedFile"><br>
        file:<input type="file" name="uploadedFile"><br>
        <input type="submit" value="开始上传">
    </form>

    <%--浏览器语言首选项会影响 页面的国际化翻译--%>
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

<script type="text/javascript">
    $("a:first").click(function (){
        $.ajax({
            url:"${ctp}/jackson/1",
            type:"GET",
            /*dataType:"json", //不加这个属性也能识别json格式*/
            success:function(data){
                $.each(data,function () {
                   var user = this.id +"---"+this.name+"---"+this.age+"---"+ this.password;
                   $("div").append(user+"<br>");
                });
            }
        });
        return false;//不加这一句的话就直接跳转到了json的请求体，什么都不跳，这样数据才能显示到页面的div中
    });

    /* 选择器：全都是细节！*/
    $("h3:nth-of-type(2) a").click(function () {
        var user = {id:100,name:"laowang",age:31,password:"kshje94h",birth:"2000-01-12"};
        var jsonuser = JSON.stringify(user);
        $.ajax({
            url: "${ctp}/jackson/3",
            type: "POST",
            data:jsonuser,
            contentType: "application/json",
            success:function (data) {
                alert(data.id+"~~"+data.name+"~~"+data.age+"~~"+data.password+"~~"+data.birth);
            }
        });
        return false;
    });

</script>

</html>
