<%--
  Created by IntelliJ IDEA.
  User: hesenbai
  Date: 2020/6/13
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">

  <title>用户登录界面</title>

  <!-- Bootstrap core CSS -->
  <link href="../css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../css/signin.css" rel="stylesheet">


</head>

<body>

  <div class="container">
    <form class="form-signin" action="/Login" method="post">
      <h2 class="form-signin-heading">用户登录程序</h2>
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

      <h2 class="form-signin-heading">请登录</h2>
      <label for="inputEmail" class="sr-only">用户名</label>
      <input type="email" id="inputEmail" name="email" class="form-control" placeholder="邮件地址" required autofocus>
      <label for="inputPassword" class="sr-only">密码</label>
      <input type="password" id="inputPassword" name="psw" class="form-control" placeholder="密码" required>
      <div class="checkbox">
        <label>
          <input type="checkbox" value="remember-me" > 记住我
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      <div>
        <a href="register.jsp" class="form-register">注册一下</a>
      </div>
    </form>

  </div>

  </body>
</html>
