package practice.demo.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MyWinDemo {

    private Frame f;
    private TextField tf;
    private Button btn;
    private TextArea ta;
    private Dialog d;
    private Label lab;
    private Button okbtn;

    MyWinDemo() {
        init();
    }

    private void init() {
        f = new Frame("my Window");
        f.setBounds(300, 100, 600, 500);
        f.setLayout(new FlowLayout());

        tf = new TextField(60);

        btn = new Button("转到");
        ta = new TextArea(25, 70);

        d = new Dialog(f, "提示信息-self", true);
        d.setBounds(400, 200, 250, 150);
        d.setLayout(new FlowLayout());

        lab = new Label();
        okbtn = new Button("确定");

        d.add(lab);
        d.add(okbtn);


        f.add(tf);
        f.add(btn);
        f.add(ta);

        myEvent();
        f.setVisible(true);

    }


    private void myEvent() {

        //添加 回车 时候 自动转到
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    showDir();
                }
            }
        });
        //确定按钮事件
        okbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                d.setVisible(false);
            }
        });

        d.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                d.setVisible(false);
            }

        });

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showDir();
            }

        });


        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });

    }

    private void showDir() {
        String dirPath = tf.getText();

        File dir = new File(dirPath);
        if (dir.exists() && dir.isDirectory()) {
            ta.setText("");
            String[] names = dir.list();
            for (String name : names) {
                ta.append(name + "\r\n");
                //ta.setText(text);
            }
        } else {
            String info = "您输入的信息:" + dirPath + "有误,请重新输入";
            lab.setText(info);
            d.setVisible(true);
        }

        tf.setText("");
    }

    public static void main(String[] args) {
        new MyWinDemo();
    }

}

