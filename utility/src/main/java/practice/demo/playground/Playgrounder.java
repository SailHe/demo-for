package practice.demo.playground;

import practice.demo.shape.MyCircle;
import practice.demo.shape.MyLine;
import practice.demo.shape.MyPoint;
import practice.demo.shape.MyShape;
import practice.util.Assert;

import java.util.*;


/**
 * Description: 无描述类<p>
 *
 * @Package: practice.demo
 * @author: SailHe
 * @date: 2018/11/12 19:18
 */
public class Playgrounder {
    private static void containerTest() {
        Collection container;
        // Map没有实现Collection
        Map<Integer, Integer> m = new HashMap(10);
        // 但set实现了
        Set set = m.entrySet();
        container = set;
        container.iterator();
        set.iterator();
        // Collection
        List<Integer> l = new LinkedList<Integer>();
        l.add(1);
        container = l;

        Assert.isTrue(l.iterator().next().equals(container.iterator().next()), "迭代器内容相等");
        Assert.isTrue(l.iterator().next() == container.iterator().next(), "迭代器地址相等");
        Assert.isTrue(false, "错误测试");
    }

    public static void main(String[] args) {
        containerTest();
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
