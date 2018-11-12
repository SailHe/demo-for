package practice.demo.shape;

/**
 * Descriptions: 长方体<p>
 *
 * @author SailHe
 * @date 2018/11/12 19:14
 */
public class MyCuboid extends MySquare {
    private int height;

    public MyCuboid() {
    }

    public MyCuboid(int height) {
        this.height = height;
    }

    public int volume() {
        return area() * height;
    }
}
