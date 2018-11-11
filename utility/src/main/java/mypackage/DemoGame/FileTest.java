package mypackage.DemoGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("mnt/sdcard/external_sd/SJ_save.txt");
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
            /*byte buy[] = Object.getBytes();
            out.write(buy);
            out.close();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream in = new FileInputStream(file);
            byte byt[] = new byte[1024];
            int len = in.read(byt);
            System.out.println("文件信息为" + new String(byt, 0, len));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
