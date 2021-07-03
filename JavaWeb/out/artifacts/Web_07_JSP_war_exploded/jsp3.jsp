<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/3
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <%@include file="common/header.jsp"%>
    <h2>网页主体</h2>
    <%@include file="common/footer.jsp"%>
    <hr>

    <%--JSP标签--%>
    <jsp:include page="${pageContext.request.contextPath}/common/header.jsp"/>
    <h2>网页主体</h2>
    <jsp:include page="${pageContext.request.contextPath}/common/footer.jsp"/>

</body>
</html>
