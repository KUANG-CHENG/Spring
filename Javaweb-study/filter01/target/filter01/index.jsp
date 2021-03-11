<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<h1>当前有<span style="color: blue"><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span>人在线。</h1>
</body>
</html>
