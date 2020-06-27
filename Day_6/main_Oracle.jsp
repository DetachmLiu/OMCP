<%--
  Created by IntelliJ IDEA.
  User: axtb
  Date: 2020/6/27
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- jQuery文件 -->
<script src="../js/jquery.min.js"></script>
<script src="../js/music_lyric.js"></script>


<link href="../css/main_css.css" rel="stylesheet">
<html>
<head>
    <title>主界面</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/style.css">

</head>

<body>
<div class="div1">
    <b>
        <h2 style="font-size: xx-large;margin-top: 30px;text-shadow: 5px 5px 5px #ccccc1;">OMCP——聆听世界！</h2>
    </b>
</div>

<div class="div2_image">
    <img src="../image/1.jpg"  id="loader" style="border-radius:50%" class="img">
</div>

<div class="div3_video" >
    <audio  class="audio"  id="player" onplay="getLyric()"   preload="auto" autoplay="autoplay">
        <source src="https://music.163.com/song/media/outer/url?id=557601772" />
    </audio>


    <div id="lyrics" ></div>



    <%--    <button type="button" value="love" >--%>
    <%--        <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>--%>

    <%--    </button>--%>
    <%--    <audio  controls="controls" >--%>
    <%--        <source src="../video/2.mp3" type="audio/mpeg">--%>
    <%--    </audio>--%>
</div>

<div class="div4">

    <div>
        <button class="login-button fr" onclick="window.location.href='../jsp/login.jsp'"><span>登录</span></button>
        <button class="login-button fr" onclick="window.location.href='../jsp/register.jsp'"><span>注册</span></button>
    </div>
    <form action="/SelectServlet">
    <div style="position: relative; top: 10px;">

        <button class="login-button fr" ><span>查询</span></button>

    </div>
    </form>
</div>


</body>
</html>

