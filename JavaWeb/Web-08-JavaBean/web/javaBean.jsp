<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/4
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <jsp:useBean id="person" class="pojo.Person" scope="page"/>

    <jsp:setProperty name="person" property="id" value="1"/>
    <jsp:setProperty name="person" property="name" value="云小杰"/>
    <jsp:setProperty name="person" property="age" value="23"/>
    <jsp:setProperty name="person" property="address" value="潍坊"/>

    Id: <jsp:getProperty name="person" property="id"/>
    Name: <jsp:getProperty name="person" property="name"/>
    Age: <jsp:getProperty name="person" property="age"/>
    Address: <jsp:getProperty name="person" property="address"/>

</body>
</html>
