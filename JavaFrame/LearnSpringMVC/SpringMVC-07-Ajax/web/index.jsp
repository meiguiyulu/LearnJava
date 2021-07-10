<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/10
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
<%--    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>--%>
    <link rel="stylesheet" href="statics/js/jquery-3.6.0.js">

    <script>
      function test(){
        $.post({
          url: "${pageContext.request.contextPath}/test2",
          data: {"name": $("#username").val()},
          success: function (data){
            alert(data);
          }
        })
      }
    </script>

  </head>
  <body>
    <%--失去焦点的时候 发起一个请求到后台--%>
  用户名：<input type="text" id="username" onclick="test()">
  </body>
</html>
