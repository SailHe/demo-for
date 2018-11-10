<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>删除</title>
</head>
<body>
<%
    /*< %这里可以写程序语言(服务器端代码)% >*/
    //实例化驱动
    ///Class这个类可以根据类名new对象
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    //创建连接
    Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://127.0.0.1/sail_he", "sailhe", "123456@password");
    Statement stmt = con.createStatement();
    //返回记录集
    int rowCount = stmt.executeUpdate("delete from sys_user");
    //关闭连接、释放资源
    stmt.close();
    con.close();
    /**
     Connection con = DriverManager
     .getConnection("jdbc:mysql://rm-bp107u76bj797lr7wo.mysql.rds.aliyuncs.com:3306/sail_he", "song", "song@1234");
     //Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sail_he", "sailhe", "123456@password");
     //灵活指定sql变量的statement
     PreparedStatement psm = con.prepareStatement("DELETE FROM basic_province WHERE user_id = (?)");
     psm.setInt(1, delId.intValue());//将第一个?设置为delId
     psm.executeUpdate();
     //记得关闭
     psm.close();
     con.close();
     * */
%>
<%=rowCount + "条记录已被删除"%>
</body>
</html>
