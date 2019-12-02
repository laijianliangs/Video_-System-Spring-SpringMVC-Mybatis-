<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/1
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加视频页面</title>
    <meta http-equiv="Content-Type" content="multipart/form-data;charset=utf-8"/>
</head>
<body>
<center>
    <h1>添加视频</h1>
    <form action="savefilm" style="font-size: 14px" method="post" enctype="multipart/form-data">

        <table>
            <tr>
                <td>视频名称</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>视频类型</td>
                <td>
                    <select name="type" style="width:170px">
                        <c:forEach items="${listfilm}" var="p">
                            <option value="${p.type}">${p.type}</option>
                        </c:forEach>
                    </select></td>
            </tr>
            <tr>
                <td>视频URL</td>
                <td><textarea rows="10" cols=" 30" name="htmlurl"></textarea></td>
            </tr>
            <tr>
                <td>上传封面：</td>
                <td><input type="file" name="file"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>

</center>

</body>
</html>
