package practice.demo;

import practice.demo.shape.MyCircle;
import practice.demo.shape.MyLine;
import practice.demo.shape.MyPoint;
import practice.demo.shape.MyShape;


interface Say {
    Blessing say(String word);
}

/**
 * Descriptions: 年份<p>
 *
 * @author SailHe
 * @date 2018/11/12 19:20
 */
class Year implements Say {
    String year;

    public Year(String year) {
        this.year = year;
    }

    @Override
    public Blessing say(String word) {
        System.out.printf(word);
        return new Blessing(year);
    }
}

class Blessing {
    String blessing;

    public Blessing(String blessing) {
        this.blessing = blessing;
    }

    void realize() {
        System.out.println(blessing);
    }
}


/**
 * Description: 无描述类<p>
 *
 * @Package: practice.demo
 * @author: SailHe
 * @date: 2018/11/12 19:18
 */
public class Playground {
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
