<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/4
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="header">
    <div class="title"></div>
    <div class="welcome">欢迎您：${sessionScope.user.userName}</div>
</div>
</body>
</html>