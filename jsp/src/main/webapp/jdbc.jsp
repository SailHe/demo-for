<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP连接My SQL数据库及简易增删操作代码</title>
</head>
<body>
<%--在HTML5 中不支持该标签请使用CSS代替--%>
<div style="text-align: center;">
    <table border=1 style="font-family: 幼圆;">
        <tr>
            <td align="center" width="100px">序号</td>
            <td align="center" width="100px">用户名</td>
            <td align="center" width="100px">年龄</td>
        </tr>
        <%
            /*1，注册加载一个driver驱动
              2，创建数据库连接（Connection）
              3，创建一个Statement（发送sql）
              4，执行sql语句
              5，处理sql结果（select语句）
              6，关闭Statement
              7，关闭连接Connection。
             */
            Connection connection = null;
            //PreparedStatement
            Statement stmt = null;
            ResultSet rst = null;
            try {
                /*//实例化驱动
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //创建连接
                connection = java.sql.DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1/sail_he", "sailhe", "123456@password");*/


                //加载属性文件，读取数据库连接配置信息
                Properties pro = new Properties();
                try {
                    //pro.load(JDBC_BaseDAO.class.getResourceAsStream("/jdbc.properties"));
                    //关键的代码
                    pro.load(Thread.currentThread()
                            .getContextClassLoader()
                            .getResourceAsStream("/jdbc.properties"));
                } catch (IOException e) {
                    System.out.println("未找到配置文件！！！");
                }
                String driverClass = pro.getProperty("jdbc.driverClassName");
                // 加载驱动
                Class.forName(driverClass);
                String url = pro.getProperty("jdbc.url");
                String user = pro.getProperty("jdbc.username");
                String password = pro.getProperty("jdbc.password");
                connection = DriverManager.getConnection(url, user, password);


                stmt = connection.createStatement();
                //返回记录集
                rst = stmt.executeQuery("select * from sys_user");
                while (rst.next()) {
                    out.println("<tr>");
                    out.println("<td align='center'>" + rst.getInt("user_id") + "</td>");
                    out.println("<td align='center'>" + rst.getString("user_name") + "</td>");
                    out.println("<td align='center'>" + rst.getInt("user_age") + "</td>");
                    out.println("</tr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {//关闭连接、释放资源
                try {
                    if (rst != null) {
                        rst.close();//后打开的先关
                        //rst = null;//其实会自动置null
                    }
                    if (stmt != null) {
                        stmt.close();
                        //stmt = null;
                    }
                    if (connection != null)
                        connection.close();
                } catch (Exception e) {
                    e.printStackTrace();//应当写log
                }
            }
        %>
    </table>
</div>
</body>
</html>
