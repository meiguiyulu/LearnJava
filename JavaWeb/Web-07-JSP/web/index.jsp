<%--
  Created by IntelliJ IDEA.
  User: LYJ
  Date: 2021/7/3
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%--
  JSP表达式
  <%= 变量或者表达式%>
  --%>
  <%= new java.util.Date()%>
  <hr>
  <%--JSP脚本片段--%>
  <%
    int sum = 0;
    for (int i=1;i<=100;++i){
      sum += i;
    }
    out.println("<h1>sum=" + sum + "</h1>");
  %>

  <%
    int x = 20;
    out.println("x=" + x);
  %>
  <p>这是一个JSP文档</p>
  <%
    x = x + 1;
    out.println("x + 1 = " + x);
  %>
  <hr>
  <%--在代码中嵌入HTML元素--%>
  <%
    for (int i=0;i<5;++i){
  %>
    <h3> 第<%=i%>次, Hello World!</h3>
  <%
    }
  %>

<%--  &lt;%&ndash;EL表达式&ndash;%&gt;--%>
<%--  <% for (int i=0;i<5;++i) {%>--%>
<%--    <h3> 第${i}次, EL表达式!</h3>--%>
<%--  <% } %>--%>

  <hr>

  <%!
    static {
      System.out.println("Loading Servlet!");
    }
    private int globalVar = 0;

    public void Method(){
      System.out.println("进入了方法!");
    }
  %>
  <hr>
  <%--这是JSP的注释--%>
  <!--这是HTML的注释-->

  </body>
</html>
