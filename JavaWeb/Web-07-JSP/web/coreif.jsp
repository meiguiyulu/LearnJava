<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/4
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <h4>if测试</h4>
    <form action="coreif.jsp" method="get">
        <%--
            EL表达式获取表单中的数据
            ${param.参数名}}
        --%>
        <input type="text" name="username" value="${param.username}">
        <input type="submit" name="登录">
    </form>

<%--判断的提交的用户名是否是管理员，是的话则登陆成功--%>
<c:if test="${param.username =='admin'}" var="IsAdmin">
    <c:out value="欢迎管理员"></c:out>
</c:if>
<c:out value="${IsAdmin}"/>

</body>
</html>
