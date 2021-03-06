package practice.acm.tips;

import java.util.*;

/**
 * Descriptions: 构造类题目<p>
 *
 * @author SailHe
 * @date 2018/11/12 17:52
 */
public class Construction {
    /**
     * Descriptions: 构造题考思维
     * n个数的序列，构造24，每个数用一次，构造出的数可以不用完
     * n < 4 无解
     * n = 4,5都能构成24
     * 奇数结尾调用1 2 3 4 5 构成24；(操作次数k = 3)
     * 偶数结尾调用1 2 3 4   构成24；(操作次数k = 4)
     * 剩下的数要保证操作n-k次
     * 通过后一个减前一个数，构造1     (操作k2次)
     * 然后1乘24保证最后一个数是24    (操作k3次)<p>
     *
     * @author SailHe
     * @date 2018/11/12 17:51
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n < 4) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                int k2 = 0;
                if (n % 2 == 0) {
                    for (int i = 5; i < n; i += 2) {
                        System.out.printf("%d - %d = 1\r\n", i + 1, i);
                        k2++;
                    }
                    System.out.println("1 * 2 = 2");
                    System.out.println("2 * 3 = 6");
                    System.out.println("4 * 6 = 24");
                    for (int i = n - 1 - k2 - 4; i > 0; i--) {
                        System.out.println("24 * 1 = 24");
                    }
                } else {
                    for (int i = 6; i < n; i += 2) {
                        System.out.printf("%d - %d = 1\r\n7", i + 1, i);
                        k2++;
                    }
                    System.out.println("4 * 5 = 20");
                    System.out.println("3 - 1 = 2");
                    System.out.println("2 + 2 = 4");
                    System.out.println("20 + 4 = 24");
                    for (int i = n - 1 - k2 - 4; i > 0; i--) {
                        System.out.println("24 * 1 = 24");
                    }
                }
            }
        }
    }
}
