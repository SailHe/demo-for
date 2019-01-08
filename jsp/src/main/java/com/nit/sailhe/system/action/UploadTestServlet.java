package com.nit.sailhe.system.action;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Descriptions: 注解的方式声明servlet的路径<p>
 *
 * @author SailHe; @see https://blog.csdn.net/u013632854/article/details/73276992
 * @date 2019/1/7 20:45
 */
@WebServlet("/UploadTestServlet")
public class UploadTestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * 上传目录名
     */
    private static final String UPLOAD_DIR = "uploadDir/img/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UploadTestServlet in");

        // ---- 初始化部分
        //设置编码格式，前端后台统一是utf-8
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        // ----- 文件路径部分 用的是项目发布的相对路径

        // Servlet上下文对象
        ServletContext servletContext = this.getServletConfig().getServletContext();
        // tomcat的项目路径，记住要加斜杠; 保存名
        String fileName = "test.jpg";
        // 保存的路径
        String realPath = servletContext.getRealPath(UPLOAD_DIR) + "/";
        // 合起来就是完整的文件路径了
        String filePath = realPath + fileName;
        System.out.println("UploadTestServlet filePath:" + filePath);
        File realPathFile = new File(realPath);
        if (!realPathFile.exists()) {
            if (!realPathFile.mkdirs()) {
                throw new ServletException("路径创建失败!");
            } // else do nothing
        }

        // ----- 读写部分
        // 传给页面的输出流
        ServletInputStream sis = request.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = sis.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // 关闭资源
        fos.close();
        sis.close();

        // 把图片地址，转发回页面
        try {
            request.setAttribute("path", UPLOAD_DIR + fileName);
            System.out.println("UploadTestServlet path:" + UPLOAD_DIR + fileName);
            request.getRequestDispatcher("/test/UploadTest.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}
