<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/10
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>

    <script>
        function a1(){
            $.post({
                url: "${pageContext.request.contextPath}/test4",
                data: {"name": $("#name").val()},
                success: function (data){
                    if (data.toString() === 'OK'){
                        $("#userInfo").css("color", "green");
                    } else {
                        $("#userInfo").css("color", "red");
                    }
                    $("#userInfo").html(data);
                }
            })
        }
        function a2(){
            $.post({
                url: "${pageContext.request.contextPath}/test4",
                data: {"name": $("#pwd").val()},
                success: function (data){
                    if (data.toString() === 'OK'){
                        $("#pwdInfo").css("color", "green");
                    } else {
                        $("#pwdInfo").css("color", "red");
                    }
                    $("#userInfo").html(data);
                }
            })
        }
    </script>

</head>
<body>
    <p>
        用户名：<input type="text" id="name" onblur="a1()">
        <span id="userInfo"></span>
    </p>
    <p>
        密码：<input type="password" id="pwd" onblur="a2()">
        <span id="pwdInfo"></span>
    </p>
</body>
</html>
