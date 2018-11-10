package com.nit.sailhe;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description: Servlet测试类
 * 需要在web.xml中配置一下, 详情参考<java web开发技术与实践P28></><p>
 *
 * @Package: PACKAGE_NAME
 * @author: SailHe
 * @date: 2018/9/28 19:19
 */
public class SampleServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
