<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/14
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data" method="post">
    上传用户: <input type="text" name="username"> <br>
    <p><input type="file" name="file1"></p>
    <p><input type="file" name="file2"></p>
    
    <p><input type="submit">|<input type="reset"></p>
  </form>
  </body>
</html>
