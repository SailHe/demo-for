package mypackage.acm;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Descriptions: Created by 魔诃不思议 on 2017/7/18.<p>
 *
 * @author SailHe
 * @date 2018/11/11 17:57
 */
public class Main {
    /**
     * Descriptions: n位interesting number的后n-1,n-2,n-3,....,1位一定单独也是interesting number
     * 方法：通过一个m位的in num枚举第m+1位上的数，判断是否构成interesting number<p>
     *
     * @author SailHe
     * @date 2018/11/11 17:56
     */
    static void calc(BigInteger[] num) {
        int front = 1;
        BigInteger m = BigInteger.valueOf(1);
        num[0] = BigInteger.valueOf(0);
        while (true) {
            int ft = front;
            for (int i = 1; i < 10; i++) {
                for (int k = 0; k < ft; k++) {
                    BigInteger iNum = num[k].add(m.multiply(BigInteger.valueOf(i)));
                    BigInteger tmp = iNum.modPow(BigInteger.valueOf(2), m.multiply(BigInteger.valueOf(10)));
                    if (tmp.compareTo(iNum) == 0) {
                        num[front++] = iNum;
                        if (front > 25) {
                            return;
                        }
                    }
                }
            }
            m = m.multiply(BigInteger.valueOf(10));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger[] num = new BigInteger[27];
        calc(num);
        while (in.hasNext()) {
            System.out.println(num[in.nextInt() - 1]);
        }
    }
}
