<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../css/main_css.css" rel="stylesheet">
<link href="../layui/css/layui.css" rel="stylesheet">
<html>
<head>
    <title>主界面</title>
</head>
<body>
<div class="div1_search">
    <b>
        <h2>OMCP———聆听世界！</h2>
    </b>
    <form action="${pageContext.request.contextPath}/Search" method="get">
        <input type="text" name="search" style="height: 31px" >
        <input type="submit" value="搜索">
    </form>
</div>
<div class="div2_image">
    <img src="../image/1.jpg"  style="border-radius:50%" >
</div>
<%--
    1. form 表单使用 action 调用 servlet，
    servlet 接受前台参数信息，并在方法内
    调用和实例化工具类获得所需要的信息。
    2. 利用 request 对应后台使用 setAttribute 和 前台使用
    getAttribute，并打印出有用的信息
    3. audio 标签的限制，需要做到这首歌播放完播放下一首
    4. 歌词信息的解析和显示
    5. 专辑图片的旋转
    6. 主页样式
--%>

<div class="div3_video">
    <audio controls="controls" autoplay="autoplay">
        <source src="https://api.itooi.cn/netease/url?id=412785957&quality=flac" />
    </audio>
</div>
<div class="div4">
    <i class="layui-icon layui-icon-heart-fill" style="font-size: 30px; color: #1E9FFF;">我的收藏</i>
    <h1>
        聊天区
    </h1>
</div>
</body>
</html>