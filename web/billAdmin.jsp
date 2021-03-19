<%@ page import="com.smbs.entity.Bill" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/5
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="menu">
    <table>
        <tbody>
        <tr>
            <td>
                <form method="get" action="LookupBillServlet">
                    商品名称：
                    <label>
                        <input type="text" name="productName" class="input-text" />
                    </label>&nbsp;&nbsp;&nbsp;&nbsp;
                    是否付款：
                    <label>
                        <select name="payStatus">
                            <option value="">请选择</option>
                            <option value="1">已付款</option>
                            <option value="0">未付款</option>
                        </select>
                    </label>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" name="submit" value="组合查询" class="button" />
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="main">
    <div class="optitle clearfix">
        <em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='PreAddBillServlet'" /></em>
        <div class="title">账单管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tr>
                <td>账单编号</td>
                <td>商品名称</td>
                <td>商品描述</td>
                <td>商品数量</td>
                <td>交易金额</td>
                <td>是否付款</td>
                <td>供应商名称</td>
                <td>账单时间</td>
                <td style="width: 100px"><div class="STYLE1" style="text-align: center">操作</div></td>
            </tr>
            <c:forEach items="${requestScope.bills}" var="b" varStatus="bs">
                <tr>
                    <td>${b.billId}</td>
                    <td>${b.productName}</td>
                    <td>${b.productDesc}</td>
                    <td>${b.productCount}</td>
                    <td>${b.totalPrice}</td>
                    <td>
                        <c:choose>
                            <c:when test="${b.isPayment()==1}">
                                已付款
                            </c:when>
                            <c:otherwise>
                                未付款
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:forEach items="${requestScope.providers}" var="p">
                            <c:if test="${b.providerId==p.providerId}">
                                ${p.providerName}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
<%--                        <fmt:formatDate value="${b.createTime}" pattern="yyyy-MM-dd HH:mm:ss" type="both" var="create_time" scope="request"/>--%>
<%--                        ${create_time}--%>
                        ${b.createTime}
                    </td>
                    <td style="width: 100px"><div class="STYLE1" style="text-align: center"><a href="PreUpdateBillServlet?billId=${b.billId}">修改</a></div></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>