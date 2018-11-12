package practice.demo.shape;

/**
 * Description: 无描述类<p>
 *
 * @Package: practice.demo
 * @author: SailHe
 * @date: 2018/11/12 19:05
 */
public class MyCircle implements MyShape {
    private MyPoint center;
    private Integer radius;

    public MyCircle(MyPoint center, Integer radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("圆类Draw");
    }
}
