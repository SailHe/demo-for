package practice.demo.playground;

import practice.demo.shape.MyCircle;
import practice.demo.shape.MyLine;
import practice.demo.shape.MyPoint;
import practice.demo.shape.MyShape;


/**
 * Description: 无描述类<p>
 *
 * @Package: practice.demo
 * @author: SailHe
 * @date: 2018/11/12 19:18
 */
public class Playgrounder {
    public static void main(String[] args) {
        /*第一次*/
        Say happy = new Year("2018");
        Blessing blessing = happy.say(" HelloWorldForThread World");
        blessing.realize();

        /*第二次*/
        MyPoint p = new MyPoint(1, 1);
        p.draw();
        MyShape line = new MyLine(p, 10);
        line.draw();
        MyShape circle = new MyCircle(p, 101);
        circle.draw();
    }
}
