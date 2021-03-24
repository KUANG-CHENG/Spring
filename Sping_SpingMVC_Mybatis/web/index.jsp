<%--
  Created by IntelliJ IDEA.
  User: 华为
  Date: 2021/3/17
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
  <title>首页</title>
  <style type="text/css">
    <!-- 超链接设置 -->
    a {
      text-decoration: none;  <!-- 取消下划线 -->
      color: black;
      font-size: 18px;
    }
    h3 {
      width: 180px;
      height: 38px;
      margin: 100px auto;
      text-align: center;
      line-height: 38px;
      background: deepskyblue;
      border-radius: 4px;  <!-- 圆角边框 -->
    }
  </style>
</head>
<body>

<h3>
  <!-- 取绝对地址 -->
  <a href="${pageContext.request.contextPath}/book/allBook">点击进入列表页</a>
</h3>
</body>
</html>
