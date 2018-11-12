package practice.demo.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

/**
 * 实现菜单栏
 */
public class MyMenuDemo {


    private Frame f;
    private MenuBar mb;
    private Menu m, subm;
    private MenuItem closeItem, openItem, saveItem, subItem1, subItem;
    private FileDialog openDialog, saveDialog;
    private TextArea ta;
    private File file;

    MyMenuDemo() {
        init();
    }

    private void init() {
        f = new Frame("my Window");
        f.setBounds(300, 100, 600, 500);
        //f.setLayout();

        mb = new MenuBar();
        m = new Menu("文件");

        closeItem = new MenuItem("退出");
        openItem = new MenuItem("打开");
        saveItem = new MenuItem("保存");

        subm = new Menu("新建");
        subItem1 = new MenuItem("Web Project");
        subItem = new MenuItem("Java Project");
        subm.add(subItem);
        subm.add(subItem1);

        m.add(subm);
        m.add(openItem);
        m.add(saveItem);
        m.add(closeItem);
        mb.add(m);

        openDialog = new FileDialog(f, "我要打开", FileDialog.LOAD);
        saveDialog = new FileDialog(f, "我要保存", FileDialog.SAVE);

        ta = new TextArea();

        f.add(ta);
        f.setMenuBar(mb);
        myEvent();

        f.setVisible(true);

    }

    private void myEvent() {

        saveItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (file == null) {
                    saveDialog.setVisible(true);
                    String dirPath = saveDialog.getDirectory();
                    String fileName = saveDialog.getFile();
                    if (dirPath == null || fileName == null)
                        return;
                    file = new File(dirPath, fileName);
                }
                try {

                    BufferedWriter bufw = new BufferedWriter(new FileWriter(file));

                    String text = ta.getText();

                    bufw.write(text);
                    bufw.close();
                } catch (IOException e2) {
                    throw new RuntimeException("保存失败");
                }

            }
        });

        //打开菜单
        openItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                openDialog.setVisible(true);
                String dirPath = openDialog.getDirectory();
                String fileName = openDialog.getFile();
                System.out.println(dirPath + "...." + fileName);
                if (dirPath == null || fileName == null)
                    return;
                ta.setText("");
                file = new File(dirPath, fileName);
                try {
                    BufferedReader bufr = new BufferedReader(new FileReader(file));
                    String line = null;
                    while ((line = bufr.readLine()) != null) {
                        ta.append(line + "\r\n");
                    }
                    bufr.close();
                } catch (IOException e2) {
                    throw new RuntimeException("打开异常");
                }

            }
        });


        closeItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MyMenuDemo();
    }

}
