package practice.acm.tips;

import java.math.BigInteger;
import java.util.*;
/*
* ①n-1的合法队列     ..... + M
* ②n-1不合法队列     ....F + F
*  <==> n-2的合法队列....  + FF
* ③n-2不合法队列     ...F  + FF
*  <==> n-4的合法队列..    + MF  + FF
思路来源：http://www.clanfei.com/2012/04/379.html蓝飞技术格
* */

/**
 * Descriptions: [ACM_HDU_1297]Children’s Queue<p>
 *
 * @author SailHe
 * @date 2018/11/12 17:55
 */
public class Recursion {
    void demo() {
        //获取开始时间
        long startTime = System.nanoTime();
        //获取结束时间
        long endTime = System.nanoTime();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger[] f = new BigInteger[1001];
        f[0] = BigInteger.valueOf(1);
        f[1] = f[0];
        f[2] = BigInteger.valueOf(2);
        f[3] = BigInteger.valueOf(4);
        for (int n = 4; n < 1001; n++) {
            f[n] = f[n - 1].add(f[n - 2].add(f[n - 4]));
        }

        while (in.hasNext()) {
            System.out.println(f[in.nextInt()]);
        }
    }
}
