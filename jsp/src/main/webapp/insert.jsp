<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Random" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据插入</title>
</head>
<%--https://gitee.com/nit-zju_admin/dba/tree/master--%>
<body>
<%
    //实例化驱动
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    //创建连接
    Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://127.0.0.1/sail_he", "sailhe", "123456@password");
    Statement stmt = con.createStatement();
    int user_age = Math.abs(new Random().nextInt() % 100) + 10;
    //返回记录集
    int rowCount = stmt
            .executeUpdate("insert into sys_user(user_name,user_age) values('插入于" + new Date().toString() + "'," + user_age + ")");
    //关闭连接、释放资源
    stmt.close();
    con.close();
%>
<%="插入了" + rowCount + "条记录"%>
</body>
</html>
