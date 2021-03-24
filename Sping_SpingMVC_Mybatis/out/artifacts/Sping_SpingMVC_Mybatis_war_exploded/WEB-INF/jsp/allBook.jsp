<%--
  Created by IntelliJ IDEA.
  User: 华为
  Date: 2021/3/17
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap 美化界面 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 —— 显示所有书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <!-- 查询书籍 -->
    <div class="col-md-4 column"></div>
    <div class="col-md-4 column">
        <form class="form-inline" action="/book/queryBook" method="post"
              style="float: right">
            <%-- 使用 <span> 元素对文本中的一部分进行着色 --%>
            <span style="color: red;font-weight: bold">${error}</span>
            <input type="text" name="queryBookName" class="form-control"
                   placeholder="输入查询书名" required>
            <input type="submit" value="查询" class="btn btn-primary">
        </form>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <!-- 新增按钮 -->
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <!-- 获取后端list数据 -->
                <c:forEach var="book" items="${requestScope.get('list')}">
                    <tr>
                        <td>${book.getBookID()}</td>
                        <td>${book.getBookName()}</td>
                        <td>${book.getBookCounts()}</td>
                        <td>${book.getDetails()}</td>
                        <td>
                            <!-- 更改按钮 -->
                            <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.getBookID()}">更改</a> |
                            <!-- 删除按钮 -->
                            <a href="${pageContext.request.contextPath}/book/del/${book.getBookID()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
