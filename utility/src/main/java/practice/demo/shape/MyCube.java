package practice.demo.shape;

/**
 * Descriptions: 立方体<p>
 *
 * @author SailHe
 * @date 2018/11/12 19:12
 */
public class MyCube implements MyShape {
    private int height;

    @Override
    public void draw() {
        System.out.println("draw a cube");
    }

    public MyCube() {
    }

    public MyCube(int height) {
        this.height = height;
    }

    public int valume() {
        return height * height * height;
    }
}
