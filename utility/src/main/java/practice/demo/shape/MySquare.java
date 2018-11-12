package practice.demo.shape;

/**
 * Description: 无描述类<p>
 *
 * @Package: practice.demo.shape
 * @author: SailHe
 * @date: 2018/11/12 19:16
 */
public class MySquare {
    protected int w;

    public MySquare() {
    }

    public MySquare(int w) {
        this.w = w;
    }

    public int length() {
        return 4 * w;
    }

    public int area() {
        return w * w;
    }
}
