<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/11
  Time: 14:41
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
<div class="main">
    <div class="optitle clearfix">
        <div class="title">用户管理&gt;&gt;</div>
    </div>
    <form id="form1" name="form1" method="post" action="UpdateUserServlet" onsubmit="">
        <input type="hidden" name="flag" value="doAdd">
        <div class="content">
            <table class="box">
                <tr>
                    <td class="field">用户编号：</td>
                    <td><label><input type="text" name="userId" value="${requestScope.user.userId}" id="textfield" class="text" readonly="readonly"/></label> <label style="color: red;">*</label></td>
                </tr>
                <tr>
                    <td class="field">用户名称：</td>
                    <td><label><input type="text" name="username" value="${requestScope.user.userName}" class="text"/></label> <label style="color: red;">*</label></td>
                </tr>
                <tr>
                    <td class="field">用户密码：</td>
                    <td><label><input type="password" name="password" value="${requestScope.user.password}" class="text"/></label> <label style="color: red;">*</label></td>
                </tr>
                <tr>
                    <td class="field">确认密码：</td>
                    <td><label><input type="password" name="password1" value="${requestScope.user.password}" class="text"/></label> <label style="color: red;">*</label></td>
                </tr>
                <tr>
                    <td class="field">用户性别：</td>
                    <td>
                        <label for="select"></label>
                        <select name="sex" id="select">
                            <option value="女" <c:if test="${requestScope.user.gender.equals('女')}">selected="selected"</c:if>>女</option>
                            <option value="男" <c:if test="${requestScope.user.gender.equals('男')}">selected="selected"</c:if>>男</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="field">用户生日：</td>
                    <td><label><input type="date" name="birthday" value="${requestScope.user.birthday}" class="text"/></label> <label style="color: red;">*</label></td>
                </tr>
                <tr>
                    <td class="field">用户电话：</td>
                    <td><label><input type="text" name="mobile" value="${requestScope.user.phone}" class="text"/></label> <label style="color: red;">*</label></td>
                </tr>
                <tr>
                    <td class="field">用户地址：</td>
                    <td>
                        <label>
                            <textarea name="address" id="textarea" class="text" cols="1" rows="3">${requestScope.user.address}</textarea>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class="field">用户权限：</td>
                    <td>
                        <label><input type="radio" name="auth" value="0" checked="checked"/>普通用户</label>
                        <label><input type="radio" name="auth" value="1" />经理</label>
                    </td>
                </tr>
            </table>
        </div>
        <div class="buttons">
            <input type="submit" name="button" value="数据提交" class="input-button"/>
            <a href="DeleteUserServlet?userId=${requestScope.user.userId}" class="input-button" style="text-decoration: none;">删除</a>
            <input name="button" value="返回" class="input-button" type="button" onclick="history.back();">
        </div>
    </form>
</div>
</body>
</html>