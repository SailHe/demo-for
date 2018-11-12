package practice.demo.shape;

/**
 * Description: 无描述类<p>
 *
 * @Package: practice.demo.shape
 * @author: SailHe
 * @date: 2018/11/12 19:08
 */
public class MyPoint implements MyShape {
    int x, y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("点类Draw " + x + " " + y);
    }
}
