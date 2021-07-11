<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/11
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<%--WEB-INF下的所有页面或者资源, 只有通过controller, 或者Servlet进行访问--%>
    <h1>登陆页面</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名: <input type="text" name="username">
    密码: <input type="password" name="password">
    <input type="submit" value="登录">
</form>
</body>
</html>
