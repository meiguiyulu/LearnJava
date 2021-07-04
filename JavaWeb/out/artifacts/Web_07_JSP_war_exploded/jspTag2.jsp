<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/4
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Tis is jspTag2</h3>

    名字: <%= request.getParameter("name")%> <br>
    年龄: <%= request.getParameter("age")%>

</body>
</html>
