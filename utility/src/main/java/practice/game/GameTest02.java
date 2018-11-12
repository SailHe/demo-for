package practice.game;

import javax.swing.*;
import java.awt.*;

/**
 * https://my.oschina.net/jsky/blog/524659
 * JAVA中的游戏窗口
 * <p>
 * 让图形动起来。
 *
 * @author J_sky
 */
public class GameTest02 extends JFrame {

    int x, y, width, height;

    /**
     * 空构造器
     */
    GameTest02() {
    }

    /**
     * 游戏窗口的初始化。
     */
    void init() {

        //设置窗口的大小及位置。
        setBounds(100, 100, 400, 300);
        //设置窗口标题
        setTitle("GameTest 窗口！");
        //显示窗口
        setVisible(true);
        //窗口退出！
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        //设置背景色。
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        //设置画笔的颜色。
        g.setColor(Color.red);
        //画方形
        g.fillRect(x, y, width, height);

    }

    /**
     * 动画绘制方法。
     */
    public void draw() {
        x = 50;
        y = 50;
        width = 100;
        height = 100;
        while (true) {

            if (y < this.getHeight()) {
                y = y + 1;
            } else {
                y = 0;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        new GameTest02().init();
    }
}
