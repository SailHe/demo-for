package practice.util;

import java.awt.*;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * Descriptions: Created by 魔诃不思议 on 2017/7/12.<p>
 * double 累加会出现偏差：题目 Gauß in Elementary School
 *
 * @author SailHe
 * @date 2018/11/11 18:50
 */
public class MyNumber {
    /**
     * Descriptions: 任意范围内的随机数<p>
     *
     * @author SailHe
     * @date 2018/11/11 18:50
     */
    public static int randomRange(int min, int max) {
        return min + new Random().nextInt(max - min);
    }

    public static double randomRange() {
        return new Random().nextDouble();
    }

    /**
     * Descriptions: 判断数字是否属于该区间[]<p>
     *
     * @author SailHe
     * @date 2018/11/11 18:49
     */
    public static boolean isInRange(int left, int num, int right) {
        return left <= num && num <= right;
    }

    public static int input(Scanner in) {
        /** 友好输入 */
        System.out.print("输入数字:");
        return in.nextInt();
    }

    public static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    /**
     * Descriptions: 任意底数对数<p>
     *
     * @author SailHe
     * @date 2018/11/11 18:48
     */
    public static double log(double base, double value) {
        return Math.log(value) / Math.log(base);
    }

    /**
     * Descriptions: 任意数阶乘的位数<p>
     *
     * @author SailHe
     * @date 2018/11/11 18:48
     */
    public static double factDigit(int x) {
        double ans = 1;
        for (int i = 1; i <= x; i++) {
            ans += log(10, i);
        }
        return (int) ans;
    }

    /**
     * Descriptions: 快速幂求余算法 》》输入a,k,m,求a^k%m)<p>
     *
     * @author SailHe
     * @date 2018/11/11 18:48
     */
    static long quickPower(long a, long k, long m) {
        long ans = 1;
        while (k > 0) {
            if (k % 2 == 1) {
                ans = a * ans % m;
            }
            a = a * a % m;
            k /= 2;
        }
        return ans;
    }

    /**
     * Descriptions: 返回一个斐波那契大数数组对象<p>
     *
     * @author SailHe
     * @date 2018/11/11 18:49
     */
    public static BigInteger[] fibonacci(int MAXN) {
        BigInteger[] F = new BigInteger[MAXN];
        F[1] = BigInteger.valueOf(1);
        F[2] = BigInteger.valueOf(2);
        for (int n = 3; n < MAXN; n++) {
            F[n] = F[n - 1].add(F[n - 2]);
        }
        return F;
    }

    public static double min(double a, double b) {
        return a < b ? a : b;
    }

    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    /**
     * Descriptions: 抛物线y = ax^2 + bx + c 与 直线y = kx+t 交于p2, p3两点， p1是抛物线顶点 积分求面积<p>
     * 注意Point传过来的有可能是int
     * 1/3ax^3 + 1/2(b-k)x^2 + (c-t)x |X2-X3
     *
     * @author SailHe
     * @date 2018/11/11 18:49
     */
    public static double areaParabolaLine(Point p1, Point p2, Point p3) {
        /*
        double a = (double)(p2.y - p1.y) / (double)((p1.x - p2.x) * (p1.x - p2.x));
        double b = -2.0*a*p1.x;
        double c = p1.y + a*p1.x*p1.x;
        double k = (double)(p3.y - p2.y) / (double)(p3.x - p2.x);
        double t = p3.y - k*p3.x;
        s =  (1.0/3*a*p3.x*p3.x*p3.x + 0.5*(b - k)*p3.x*p3.x + (c - t)*p3.x) - (1.0/3*a*p2.x*p2.x*p2.x + 0.5*(b - k)*p2.x*p2.x + (c - t)*p2.x);
        */
        return -(double) (p2.y - p1.y) / ((p2.x - p1.x) * (p2.x - p1.x)) * ((p3.x - p2.x) * (p3.x - p2.x) * (p3.x - p2.x)) / 6.0;
    }
}
