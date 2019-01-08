package practice.demo.test;

import java.io.*;

/**
 * Description: 无描述类<p>
 *
 * @Package: org.demo
 * @author: SailHe
 * @date: 2019/1/3 18:46
 */
public class FileTester {

    /**
     * DOC 从文件里读取数据.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void readFromFile(String root) throws FileNotFoundException, IOException {
        // 指定要读取的文件
        File file = new File(root + "/helloworld.txt");
        // 获取该文件的输入流
        FileReader reader = new FileReader(file);
        // 用来保存每次读取到的字符
        char[] bb = new char[1024];
        // 用来将每次读取到的字符拼接，当然使用StringBuffer类更好
        String str = "";
        // 每次读取到的字符长度
        int n;
        while ((n = reader.read(bb)) != -1) {
            str += new String(bb, 0, n);
        }
        // 关闭输入流，释放连接
        reader.close();
        System.out.println(str);
    }

    /**
     * DOC 往文件里写入数据.
     *
     * @throws IOException
     */
    private static void writeToFile(String root) throws IOException {
        // 要写入的文本
        String writerContent = "hello world,你好世界";
        // 要写入的文本文件
        File file = new File(root + "/helloworld.txt");
        // 如果文件不存在，则创建该文件
        if (!file.exists()) {
            file.createNewFile();
        }
        // 获取该文件的输出流
        FileWriter writer = new FileWriter(file);
        // 写内容
        writer.write(writerContent);
        // 清空缓冲区，立即将输出流里的内容写到文件里
        writer.flush();
        // 关闭输出流，施放资源
        writer.close();
    }

    public static void readPicture(String root) throws IOException {
        // 指定要读取的图片
        FileInputStream in = new FileInputStream(new File(root + "/test.png"));
        File file = new File(root + "/test.png");
        // 如果文件不存在，则创建该文件
        if (!file.exists()) {
            file.createNewFile();
        }
        writePicture(in, root);
        // 关闭输入流
        in.close();
    }

    public static void writePicture(FileInputStream in, String root) throws IOException {
        // 指定要写入的图片
        FileOutputStream out = new FileOutputStream(new File(root + "/tmp/test.png"));
        // 每次读取的总字节数
        int n;
        // 缓存每次读取的内容
        byte[] buffer = new byte[1024];
        while ((n = in.read(buffer)) != -1) {
            // 将读取的内容，写入到输出流当中
            out.write(buffer, 0, n);
        }
        // 关闭输出流
        out.close();
    }

    public static void consoleInputFile() throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }

    public static void main(String[] args) throws IOException {
        String root = "./temp/file";
        File f = new File("F://Temper/testfile.txt");
        System.out.println(f.getName());
        f = new File(root);
        f.mkdirs();

        writeToFile(root);
        readFromFile(root);

        readPicture(root);

        File fNew = new File(root + "/testfile_new.txt");
        fNew.createNewFile();
    }
}
