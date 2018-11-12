package practice.demo;

/**
 * Description: 继承测试<p>
 *
 * @Package: practice.demo
 * @author: SailHe
 * @date: 2018/11/12 16:49
 */
public class TestForExtend {
    public static void main(String[] args) {
        Color colorRed = new Color((byte) 255, (byte) 0, (byte) 0);
        double w = 50, h = 100;
        Rectangle rectangle = new Rectangle(w, h, colorRed);
        System.out.println("面积 = " + rectangle.getArea());
        System.out.println("周长 = " + rectangle.getPerimeter());
    }
}


class Color {
    private byte red, green, blue;

    public Color(byte red, byte green, byte blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}

abstract class Graphics {
    private Color color;

    public Graphics(Color color) {
        this.color = color;
    }

    /**
     * Descriptions: 返回面积<p>
     *
     * @author SailHe
     * @date 2018/11/12 16:52
     */
    public abstract double getArea();

    /**
     * Descriptions: 返回周长<p>
     *
     * @author SailHe
     * @date 2018/11/12 16:52
     */
    public abstract double getPerimeter();
}

class Rectangle extends Graphics {
    private double width, height;

    public Rectangle(double width, double height, Color color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
