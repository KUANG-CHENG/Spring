<%--
  Created by IntelliJ IDEA.
  User: 华为
  Date: 2021/3/9
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h1>登录</h1>
<div style="text-align: center">
    <%-- 以Post方式提交表单，提交到我们的login请求 --%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        爱好：
        <input type="checkbox" name="hobbys" value="女孩">女孩
        <input type="checkbox" name="hobbys" value="代码">代码
        <input type="checkbox" name="hobbys" value="唱歌">唱歌
        <input type="checkbox" name="hobbys" value="电影">电影
        <br>
        <input type="submit">
    </form>

</div>
</body>
</html>
