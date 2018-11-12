package practice.acm;

/**
 * Description: 临时类 记录一些临时的想法 有用则留 无用则丢<p>
 *
 * @Package: practice.acm
 * @author: SailHe
 * @date: 2018/11/12 16:50
 */
public class Temper {
    private int a;

    public static boolean fun(int x) {
        return 3 + x * x > 5 * (x + 3) - 1 && (x - 3 > 5);
    }

    public static void fun1() {
        int gcd, k;
        for (gcd = 3, k = 2; k <= 18; ++k) {
            if (12 % k == 0 && 16 % k == 0) {
                gcd = k;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Temper temp;
        double te = 11;
        double $dsf = 0.0;
        System.out.println("基本类型的未初始化时的默认值 a");

        int i = 2, sum = 0;
        while (i < 101) {
            sum += i;
            i += 2;
        }
        fun1();
        System.out.println(fun(1));
        System.out.println(fun(-4));
    }
}
