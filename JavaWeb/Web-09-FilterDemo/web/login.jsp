<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/4
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名:  <input type="text" name="username"> <br>
<%--        密码:  <input type="password" name="password"> <br>--%>
        <input type="submit" name="submit">
    </form>
</body>
</html>
