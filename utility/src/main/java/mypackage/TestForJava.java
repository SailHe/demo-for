package mypackage;


//import com.alibaba.fastjson.JSON;

import java.util.EmptyStackException;

abstract class AbTest {
    int a;

    AbTest(double par) {
        a = Double.valueOf(par).intValue();
        System.out.println("AbTest构造");
    }

    AbTest(int par) {
        //调用double构造方法
        this(Double.valueOf(par));
    }

    void setA(int a) {
        this.a = a;
    }

    public abstract int getA();
}

class MySquare {
    protected int w;

    MySquare() {
    }

    MySquare(int w) {
        this.w = w;
    }

    int length() {
        return 4 * w;
    }

    int area() {
        return w * w;
    }
}

class Fourprism extends MySquare {
    private int height;

    public Fourprism(){}

    public Fourprism(int height){
        this.height = height;
    }

    public int volume(){
        return area()*height;
    }
}

interface IShape{
    void draw();
}

abstract class TTT implements IShape {

}

class MyCube implements IShape {
    private int height;
    @Override
    public void draw(){
        System.out.println("draw a cube");
    }
    public MyCube(){}
    public MyCube(int height){
        this.height = height;
    }
    public int valume(){
        return height*height*height;
    }
}

class Triangle implements IShape {
    @Override
    public void draw(){
        System.out.println("Triangle Draw");
    }
}

class Circle implements IShape {
    @Override
    public void draw(){
        System.out.println("Circle Draw");
    }
}

/**
 * Description: 无描述类<p>
 *
 * @Package: mypackage
 * @author: SailHe
 * @date: 2018/7/3 10:14
 */
public class TestForJava {

    private AbTest abTest = new AbTest(10) {
        @Override
        public int getA() {
            return a;
        }
    };

    abstract static class Nackame{
        private int a;
        abstract void test();
    }

    TestForJava() {
        System.out.println("TestForJava 构造");
    }

    public static void main(String[] args) {
        //JSON;
        MySquare mySquare = new MySquare(10);
        mySquare.area();
        Nackame nnn = new Nackame() {
            @Override
            void test() {

            }
        };
        TestForJava testForJava = new TestForJava();
        AbTest abTest = new AbTest(1) {
            @Override
            public int getA() {
                return a;
            }
        };
        int a[] = new int[5];
        int b[] = {0, 1, 2};
        int c[];
        Number x = new Integer(12);
        x.intValue();
        ((Integer) x).compareTo(2);

        Number y = new Double(12);
        y.intValue();
        ((Double) y).compareTo(1.1);

        int[][] d = new int[10][];

        abTest.setA(10);
        Integer n1 = new Integer(3);
        Object n2 = new Integer(4);
        int a$ = -1;
        String s = "000ll";

        int array1[] = {0, 1};
        int array2[] = new int[2];
        array2 = array1;
        String str = new String("java");
        int index = str.indexOf('a');
        str.concat(" world");
        System.out.println(str);

        try {
            if (true) {
                throw new EmptyStackException();
            } else {
                throw new NullPointerException("1");
            }
        } catch (EmptyStackException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println(s + a$);
        //System.out.println(n1.compareTo(n2));
        //System.out.println(n2.compareTo(n1));
    }
}

class Temp_11_7{
    private int a;

    public static boolean fun(int x) {
        return 3 + x*x > 5*(x + 3)-1&&(x-3>5);
    }

    public static void fun1(){
        int gcd, k;
        for(gcd = 3, k=2; k <= 18; ++k){
            if(12%k==0 && 16%k ==0)
                gcd = k;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Temp_11_7 temp;
        double te = 11;
        double $dsf = 0.0;
        System.out.println("基本类型的未初始化时的默认值 a");

        int i = 2, sum = 0;
        while(i < 101){
            sum += i;
            i += 2;
        }
        fun1();
        System.out.println(fun(1));
        System.out.println(fun(-4));
    }
}

class Color{
    private byte red, green, blue;

    public Color(byte red, byte green, byte blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}

abstract class Graphics{
    private Color color;

    public Graphics(Color color) {
        this.color = color;
    }

    //返回面积
    public abstract double getArea();
    //返回周长
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
        return 2*(width+height);
    }
}

class Test{
    public static void main(String[] args) {
        Color colorRed = new Color((byte)255, (byte)0, (byte)0);
        double w = 50, h = 100;
        Rectangle rectangle = new Rectangle(w, h, colorRed);
        System.out.println("面积 = " + rectangle.getArea());
        System.out.println("周长 = " + rectangle.getPerimeter());
    }
}
