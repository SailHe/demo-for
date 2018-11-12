package practice.demo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//a: 导入javaGui的各种包

/**
 * Description: 无描述类<p>
 *
 * @Package: practice
 * @author: SailHe
 * @date: 2018/7/4 21:12
 */
public class GuiTestEvent extends JFrame implements ActionListener {
    JButton b1, b2;
    Container contentPane;

    public GuiTestEvent() {
        super("TestEvent.java");
        contentPane = this.getContentPane();
        //b: 设置布局模式为瀑布流
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        b1 = new JButton("长300");
        b2 = new JButton("长400");
        contentPane.add(b1);
        contentPane.add(b2);
        b1.addActionListener(this);
        //c: 为b2设置动作监听
        b2.addActionListener(this);
        this.setLocation(200, 100);
        this.setSize(200, 100);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //d: 获取传入参数事件的来源对象
        JButton b = (JButton) e.getSource();
        if (b == b1) {
            //点击的对象是b1时将此窗口的size变为(300, 100)
            this.setSize(300, 100);
        }
        if (b == b2) {
            //点击的对象是b1时将此窗口的size变为(400, 100)
            this.setSize(400, 100);
        }
    }

    public static void main(String[] args) {
        new GuiTestEvent();
    }

}
