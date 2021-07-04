<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/4
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--定义了一个变量score，值为85--%>
    <c:set var="score" value="85"/>

<c:choose>
    <c:when test="${score >= 90}">
        优秀
    </c:when>
    <c:when test="${score>=80}">
        良好
    </c:when>
    <c:when test="${score>=70}">
        一般
    </c:when>
    <c:when test="${score>=60}">
        及格
    </c:when>
    <c:when test="${score<60}">
        不及格
    </c:when>
</c:choose>

</body>
</html>
