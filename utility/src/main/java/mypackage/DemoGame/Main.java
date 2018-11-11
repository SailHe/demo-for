package mypackage.DemoGame;

import mypackage.MyNumber_;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Description: 无描述类<p>
 *
 * @Package: mypackage.DemoGame
 * @author: SailHe
 * @date: 2018/5/29 12:37
 */
class Main {
    private static int id = 0;

    private static void order(int direction, int max) {
        final String where[] = {"0", "1", "上", "3", "左", "5", "右", "7", "8下"};

        if (direction != 2 & direction != 8 & direction != 4 & direction != 6) {
            System.out.println("指令错误!请重新输入!");
        } else {

            human people;
            for (int i = 0; i < max; i++) {
                System.out.println("\n你向" + where[direction] + "走的第" + (i + 1) + "步");

                if (MyNumber_.randomRange(0, 4) == 2) {
                    people = new human(id++);
                    if (direction == 2) {
                        System.out.println("你正向下走");
                    } else if (direction == 8) {
                        System.out.println("你正向上走");
                    } else if (direction == 4) {
                        System.out.println("你正向左走");
                    } else if (direction == 6) {
                        System.out.println("你正向右走");
                    }
                    System.out.println("你遇见了:");
                    people.Special(10);
                    System.out.println(people);
                } else {
                    System.out.println("你没有遇到任何东西");
                }
            }
        }
    }

    static class Hobby extends JPanel {

        JCheckBox c1 = new JCheckBox("写作", false);

        JCheckBox c2 = new JCheckBox("音乐", false);

        JCheckBox c3 = new JCheckBox("跑步", false);

        JRadioButton rad1 = new JRadioButton("中学");

        JRadioButton rad2 = new JRadioButton("高中");

        JRadioButton rad3 = new JRadioButton("大学");

        JLabel jl = new JLabel("您有什么爱好？");

        JLabel j2 = new JLabel("爱好产生的时间？");

        JButton exitbtn = new JButton("退出");

        public Hobby() {

            setLayout(new GridLayout(9, 1));

            add(jl);
            add(c1);
            add(c2);
            add(c3);

            add(j2);
            add(rad1);
            add(rad2);
            add(rad3);
            add(exitbtn);

        }

    }

    public static void main(String[] args) {
        JFrame test = new JFrame("hello world");
        test.setSize(1000, 500);
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setContentPane(new Hobby());

        System.out.println("输入指令0开始游戏");
        Scanner in = new Scanner(System.in);
        int od = MyNumber_.input(in);
        if (od == 0) {
            System.out.println("游戏开始!!!");
            human hero = new human(id++);
            System.out.println("人物创建成功");
            System.out.println(hero);
        }
        System.out.println("需输入两条指令\n" + "2(上),8(下),4(左),6(右)" + "\n步数");
        order(MyNumber_.input(in), MyNumber_.input(in));
    }
}
