<%@ page import="com.smbs.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/4
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="menu">
    <table>
        <tbody>
        <tr>
            <td>
                <form method="post" action="LookupUserServlet">
                    <input name="flag" value="search" class="input-text" type="hidden">
                    用户名称：
                    <label>
                        <input name="userName" class="input-text" type="text">
                    </label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input value="查 询" type="submit">
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>

<div class="main">

    <div class="optitle clearfix">
        <em><input value="添加数据" class="input-button" onclick="window.location='userAdd.jsp'" type="button"></em>
        <div class="title">用户管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td style="width: 70px; height: 29px"><div class="STYLE1" style="text-align: center">序号</div></td>
                <td style="width: 80px"><div class="STYLE1" style="text-align: center">用户名称</div></td>
                <td style="width: 100px"><div class="STYLE1" style="text-align: center">性别</div></td>
                <td style="width: 100px"><div class="STYLE1" style="text-align: center">生日</div></td>
                <td style="width: 150px"><div class="STYLE1" style="text-align: center">电话 </div></td>
                <td style="width: 150px"><div class="STYLE1" style="text-align: center">地址 </div></td>
                <td style="width: 150px"><div class="STYLE1" style="text-align: center">权限 </div></td>
                <td style="width: 100px"><div class="STYLE1" style="text-align: center">操作</div></td>
            </tr>

            <c:forEach items="${requestScope.users}" var="u" varStatus="us">
                <tr>
                    <td style="width: 70px; height: 29px"><span class="STYLE1">${us.index+1}</span></td>
                    <td style="width: 80px"><span class="STYLE1">${u.userName}</span></td>
                    <td style="width: 100px"><span class="STYLE1">${u.gender}</span></td>
                    <td style="width: 100px"><span class="STYLE1">${u.birthday}</span></td>
                    <td style="width: 150px"><span class="STYLE1">${u.phone}</span></td>
                    <td style="width: 150px"><span class="STYLE1">${u.address}</span></td>
                    <td style="width: 150px"><span class="STYLE1">${u.role}</span></td>
                    <td style="width: 100px"><div class="STYLE1" style="text-align: center"><a href="PreUpdateUserServlet?userId=${u.userId}">修改</a></div></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>