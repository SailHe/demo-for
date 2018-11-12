package practice.demo.test;

import practice.demo.shape.MySquare;
import practice.demo.shape.MyShape;

import java.util.EmptyStackException;

abstract class AbTester {
    int a;

    AbTester(double par) {
        a = Double.valueOf(par).intValue();
        System.out.println("AbTest构造");
    }

    AbTester(int par) {
        //调用double构造方法
        this(Double.valueOf(par));
    }

    void setA(int a) {
        this.a = a;
    }

    public abstract int getA();
}


/**
 * Descriptions: 抽象形状类<p>
 *
 * @author SailHe
 * @date 2018/11/12 16:55
 */
abstract class AbMyShape implements MyShape {

}

/**
 * Description: 形状测试类<p>
 *
 * @Package: practice
 * @author: SailHe
 * @date: 2018/7/3 10:14
 */
public class TestForShape {

    private AbTester abTester = new AbTester(10) {
        @Override
        public int getA() {
            return a;
        }
    };

    abstract static class Nackame {
        private int a;

        abstract void test();
    }

    TestForShape() {
        System.out.println("TestForShape 构造");
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
        TestForShape testForShape = new TestForShape();
        AbTester abTester = new AbTester(1) {
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

        abTester.setA(10);
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
