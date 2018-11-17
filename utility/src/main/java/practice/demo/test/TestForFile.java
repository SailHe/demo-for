package practice.demo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Descriptions: 文件测试<p>
 *
 * @author SailHe
 * @date 2018/11/12 17:09
 */
public class TestForFile {
    public static void main(String[] args) {

        /**
         * Descriptions: 在控制台输出当前目录的文件列表<p>
         *
         * @author SailHe
         * @date 2018/11/12 22:07
         */
        File dir = new File("./");
        File[] fileS = dir.listFiles();
        for (int i = 0; i < fileS.length; ++i) {
            System.out.println(fileS[i].getName());
        }

        /**
         * Descriptions: 若存在则新建 否则删除<p>
         *
         * @author SailHe
         * @date 2018/11/12 22:09
         */
        File file = new File("./SJ_save.txt");
        if (file.exists()) {
            file.delete();
            System.out.println("删除成功");
        } else {
            try {
                file.createNewFile();
                System.out.println("文件已创建");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte[] buy = new byte[1024];
            out.write(buy);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream in = new FileInputStream(file);
            byte[] byt = new byte[1024];
            int len = in.read(byt);
            System.out.println("文件信息为" + new String(byt, 0, len));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
