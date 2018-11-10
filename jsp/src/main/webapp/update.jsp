<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>更新</title>
</head>
<body>
<%
    //实例化驱动
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    //创建连接
    Connection con = java.sql.DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1/sail_he", "sailhe", "123456@password");
    Statement stmt = con.createStatement();
    //返回记录集
    ResultSet rst = stmt.executeQuery("select * from sys_user ORDER BY user_id DESC");
    rst.next();
    out.println("原记录:</br>");
    out.println("user_id: " + rst.getInt("user_id") + "</br>");
    out.println("user_name: " + rst.getString("user_name") + "</br>");
    out.println("user_age: " + rst.getInt("user_age") + "</br>");
    //返回记录集(My SQL在int型的id外加''也没问题)
    int rowCount = stmt
            .executeUpdate("update sys_user set user_name='更新于" + new Date().toString() + "' WHERE user_id=" + rst.getInt("user_id") + "");
    //关闭连接、释放资源
    stmt.close();
    con.close();
%>
<%="更新了" + rowCount + "条记录"%>
</body>
</html>
