<%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/11
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>

<div class="main">
    <div class="optitle clearfix">
        <div class="title">账单管理&gt;&gt;</div>
    </div>
    <form method="post" action="UpdateBillServlet">
        <div class="content">
            <table class="box">
                <tr>
                    <td class="field">账单编号：</td>
                    <td>
                        <label>
                            <input type="text" name="billId" value="${requestScope.bill.billId}" class="text" readonly="readonly"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class="field">商品名称：</td>
                    <td>
                        <label>
                            <input type="text" name="productName" value="${requestScope.bill.productName}" class="text"/>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class="field">商品描述：</td>
                    <td>
                        <label>
                            <textarea name="productDesc" cols="1" rows="5" class="text">${requestScope.bill.productDesc}</textarea>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class="field">商品交易数量：</td>
                    <td>
                        <label>
                            <input type="text" name="productCount" value="${requestScope.bill.productCount}" class="text" />
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class="field">商品交易总额：</td>
                    <td>
                        <label>
                            <input type="text" name="totalPrice" value="${requestScope.bill.totalPrice}" class="text" />
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class="field">商品供应商：</td>
                    <td>
                        <label>
                            <select name="provider">
                                <c:forEach items="${requestScope.providers}" var="p">
                                    <option value="${p.providerId}" <c:if test="${requestScope.bill.providerId==p.providerId}">selected="selected"</c:if>>${p.providerName}</option>
                                </c:forEach>
                            </select>
                        </label>
                    </td>
                </tr>
                <tr>
                    <td class="field">是否付款：</td>
                    <td>
                        <label>
                            <select name="isPay">
                                <option value="1">是</option>
                            </select>
                        </label>
                    </td>
                </tr>
            </table>
        </div>
        <div class="buttons">
            <input type="submit" name="submit" value="确认" class="input-button" />
            <a href="DeleteBillServlet?billId=${requestScope.bill.billId}" class="input-button" style="text-decoration: none;">删除</a>
            <input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
        </div>
    </form>
</div>
</body>
</html>
