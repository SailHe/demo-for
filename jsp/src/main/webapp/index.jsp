<%@ page import="org.demo.Tester" language="java" %>
<%--nit.sailhe.demo.--%>
<%--<%@ page import="java.util.*" language="java" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: booler
  Date: 2018/11/9
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导航</title>
</head>
<body>

<% org.demo.SayHello s = new org.demo.SayHello();%>
<%= s.sayHello("World")%>

<% org.demo.Tester tester = new org.demo.Tester();%>
<%= tester.toString()%>

<% String tStr = new String(" --- in webapp");%>
<%= tStr%>


<a href="jdbc.jsp">显示表单</a></body>
</br>
<a href="delete.jsp">清空表单所有内容</a></br>
<a href="insert.jsp">插入一条记录(年龄随机)</a></br>
<a href="update.jsp">更新最后一条的记录</a></br>
<a href="uploadTest.jsp">上传图片</a></br>
<a href="uploadTestWebUploader.jsp">上传图片</a></br>
<%--tomcat 配置 after launch 取消勾 --%>
<%!
    int number = 0;

    synchronized void countPeople() {
        ++number;
    }
%>
<%
    countPeople();
%>
<p>您是第<%=number%>个访问者</p>

</body>
</html>
