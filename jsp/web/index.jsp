<%@ page import="org.demo.SayHello" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: booler
  Date: 2018/11/9
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% SayHello sayHello = new SayHello(); %>
<%=sayHello.sayHello("dev") %>
</body>
</html>
