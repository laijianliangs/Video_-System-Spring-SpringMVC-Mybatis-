<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/1
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>后台管理页面</title>
</head>
<body style="align-content: center">
<h1 align="center">后台管理系统</h1>
<center><a href="addfilm">添加视频</a></center>
<table border="1" align="center">
    <thead>
    <tr>
        <th>图片</th>
        <th>视频名称</th>
        <th>视频类型</th>
        <th>预览视频</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listfilm}" var="p">
        <tr style="font-size: 40px">
            <td><img height="150px" width="150px" src="${pageContext.request.contextPath}/static/imags/${p.imgurl}.png">
            </td>
            <td>${p.name}</td>
            <td>${p.type}</td>
            <td><a href="film?id=${p.id}">预览</a></td>
        <tr/>
    </c:forEach>
    </tbody>
</table>
<center>
    <a href="manager?indexPage=1">首页</a>
    <c:forEach begin="1" end="${pages}" var="p">

        <a href="manager?indexPage=${p}">${p}</a>
    </c:forEach>
    <a href="manager?indexPage=${pages}">尾页</a>
</center>
</body>
</html>