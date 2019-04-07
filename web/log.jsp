<%--
  Created by IntelliJ IDEA.
  User: 叶朝泽
  Date: 2019/4/7
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
<table border="1">
    <tr>
        <th>转账账号</th>
        <th>收款账号</th>
        <th>转账金额</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="list">
        <tr>
            <td>${list.accIn}</td>
            <td>${list.accOut}</td>
            <td>${list.money}</td>
        </tr>
    </c:forEach>
</table>
    <a href="/show?pageNum=${pageInfo.pageNum-1}&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNum<=1}"> onclick="javascript:return false" </c:if>>上一页</a>
    <a href="/show?pageNum=${pageInfo.pageNum+1}&pageSize=${pageInfo.pageSize}"<c:if test="${pageInfo.pageNum>=pageInfo.total}"> onclick="javascript:return false" </c:if>>下一页</a>
    <a href="index.jsp">转账</a>
</div>
</body>
</html>
