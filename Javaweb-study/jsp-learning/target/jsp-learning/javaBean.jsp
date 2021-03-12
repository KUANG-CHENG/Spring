<%--
  Created by IntelliJ IDEA.
  User: 华为
  Date: 2021/3/10
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="people" class="com.pojo.User" scope="page"/>

<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="name" value="kc"/>
<jsp:setProperty name="people" property="pwd" value="46543545"/>

ID：<jsp:getProperty name="people" property="id"/>
name：<jsp:getProperty name="people" property="name"/>
pwd：<jsp:getProperty name="people" property="pwd"/>

</body>
</html>
