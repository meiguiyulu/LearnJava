<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/3
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



    <jsp:forward page="jspTag2.jsp">
        <jsp:param name="name" value="yunjie"/>
        <jsp:param name="age" value="23"/>
    </jsp:forward>

</body>
</html>
