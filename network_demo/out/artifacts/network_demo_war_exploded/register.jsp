<%--
  Created by IntelliJ IDEA.
  User: axtb
  Date: 2020/6/13
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">

    <title>注册页面</title>

    <link href="register.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form class="form-signin" action="Register" mathod="post">
        <%
            request.setCharacterEncoding("utf-8");
        %>
        <%
            List<String> info=(List<String>)request.getAttribute("info");
            if(info!=null){
                Iterator<String> iter =info.iterator();
                while(iter.hasNext()){
        %>
        <h4 ><%=iter.next() %></h4>
        <%
                }
            }
        %>

        <h2 class="form-signin-heading">请注册</h2>
        <input type="text" id="inputName" name="name" class="form-control" placeholder="姓名" required autofocus>
        <input type="text" id="inputAge" name ="age" class="form-control"placeholder="年龄" required autofocus>
        <input type="email" id="inputEmail" name="email" class="form-control" placeholder="email" required autofocus>
        <input type="password" id="inputPassword" name="psw" class="form-control" placeholder="密码" required autofocus>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
        <a href="login.jsp" class="btn btn-lg btn-primary btn-block">返回登录</a>

    </form>
</div>
</body>
</html>