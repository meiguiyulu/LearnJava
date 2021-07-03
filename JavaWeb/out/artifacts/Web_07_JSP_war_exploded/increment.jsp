<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/3
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
    显式地声明这是一个错误页面: <%@ page isErrorPage="true" %>
--%>


<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    int x = 1 / 0;
%>

</body>
</html>
