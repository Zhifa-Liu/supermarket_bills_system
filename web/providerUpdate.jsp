<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/4
  Time: 21:07
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
<div class="main">
    <div class="optitle clearfix">
        <div class="title">供应商管理&gt;&gt;</div>
    </div>
    <form id="form1" name="form1" method="post" action="UpdateProviderServlet" onsubmit="">
        <div class="content">
            <input name="flag" value="doAdd" type="hidden">
            <table class="box">
                <tbody>
                <tr>
                    <td class="field">供应商编号：</td>
                    <td><label><input name="proId" value="${requestScope.provider.providerId}" class="text" type="text" readonly="readonly"/></label> <label style="color: red;">*</label></td>
                </tr>
                <tr>
                    <td class="field">供应商名称：</td>
                    <td><label><input name="proName" value="${requestScope.provider.providerName}" class="text" type="text"></label> <label style="color: red;">*</label></td>
                </tr>
                <tr>
                    <td class="field">供应商描述：</td>
                    <td>
                        <label>
                            <textarea name="proDesc" id="textarea" cols="1" rows="5" class="text">${requestScope.provider.description}</textarea>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class="field">供应商电话：</td>
                    <td><label><input name="phone" value="${requestScope.provider.telephone}" class="text" type="text"></label></td>
                </tr>
                <tr>
                    <td class="field">供应商地址：</td>
                    <td><label><input name="address" value="${requestScope.provider.address}" class="text" type="text"></label></td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="buttons">
            <input name="button" value="更新" class="input-button" type="submit">
            <a href="DeleteProviderServlet?proId=${requestScope.provider.providerId}" class="input-button" style="text-decoration: none;">删除</a>
            <input name="button" value="返回" class="input-button" type="button" onclick="history.back();">
        </div>
    </form>
</div>
</body>
</html>

