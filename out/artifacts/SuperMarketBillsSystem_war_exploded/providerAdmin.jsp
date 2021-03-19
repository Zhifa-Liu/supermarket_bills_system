<%@ page import="com.smbs.entity.Provider" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 32098
  Date: 2020/6/4
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <form method="post" action="LookupProviderServlet">
                        <input name="flag" value="search" type="hidden">
                        供应商名称：
                        <label><input name="providerName" class="input-text" type="text"></label>&nbsp;&nbsp;&nbsp;&nbsp;
                        供应商描述：
                        <label><input name="providerDesc" class="input-text" type="text"></label>&nbsp;&nbsp;&nbsp;&nbsp;
                        <label><input value="组 合 查 询" type="submit"></label>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
</div>
<div class="main">

    <div class="optitle clearfix">
        <em><input value="添加数据" class="input-button" onclick="window.location='providerAdd.jsp'" type="button"></em>
        <div class="title">供应商管理&gt;&gt;</div>
    </div>

    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td style="width: 70px; height: 29px"><div class="STYLE1" style="text-align: center">编号</div></td>
                <td style="width: 80px"><div class="STYLE1" style="text-align: center">供应商名称</div></td>
                <td style="width: 100px"><div class="STYLE1" style="text-align: center">供应商描述</div></td>
                <td style="width: 100px"><div class="STYLE1" style="text-align: center">联系人</div></td>
                <td style="width: 100px"><div class="STYLE1" style="text-align: center">电话</div></td>
                <td style="width: 100px"><div class="STYLE1" style="text-align: center">地址</div></td>
                <td style="width: 100px"><div class="STYLE1" style="text-align: center">操作</div></td>
            </tr>

            <%
                List<Provider> providers = (List<Provider>) request.getAttribute("providers");
                for(Provider p:providers){
            %>
                <tr>
                    <td style="width: 70px; height: 29px"><div class="STYLE1" style="text-align: center"><%=p.getProviderId()%></div></td>
                    <td style="width: 80px"><div class="STYLE1" style="text-align: center"><%=p.getProviderName()%></div></td>
                    <td style="width: 100px"><div class="STYLE1" style="text-align: center"><%=p.getDescription()%></div></td>
                    <td style="width: 100px"><div class="STYLE1" style="text-align: center"><%=p.getProviderName()+"批发主管"%></div></td>
                    <td style="width: 100px"><div class="STYLE1" style="text-align: center"><%=p.getTelephone()%></div></td>
                    <td style="width: 100px"><div class="STYLE1" style="text-align: center"><%=p.getAddress()%></div></td>
                    <td style="width: 100px"><div class="STYLE1" style="text-align: center"><a href="PreUpdateProServlet?proId=<%=p.getProviderId()%>">修改</a></div></td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>