<%--
  Created by IntelliJ IDEA.
  User: 华为
  Date: 2021/3/10
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:forward page="/jsptag02.jsp">
        <jsp:param name="name" value="kc"></jsp:param>
        <jsp:param name="age" value="24"></jsp:param>
    </jsp:forward>


</body>
</html>
