<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 18/8/21
  Time: 下午4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>greeting</title>
</head>
<body>
    <h1>Java in JSP</h1>
    <%
        String[] arr = {"hello","tomcat","this is a"};
        String greeting = arr[(int)(Math.random()*arr.length)];
    %>
    <p><%= greeting %></p>

</body>
</html>
