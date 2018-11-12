package practice.demo.shape;

/**
 * Description: 无描述类<p>
 *
 * @Package: practice.demo.shape
 * @author: SailHe
 * @date: 2018/11/12 19:08
 */
public class MyLine implements MyShape {
    MyPoint origin;
    Integer length;

    public MyLine(MyPoint origin, Integer length) {
        this.origin = origin;
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.println("线类Draw");
    }
}
