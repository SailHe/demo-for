package practice.demo.test;

/**
 * Description: 无描述类<p>
 *
 * @Package: practice.demo.test
 * @author: SailHe
 * @date: 2018/12/6 22:52
 */
public class TestForStr {
    public static void main(String[] args) {
        String tmp1 = new String("123");
        String tmp2 = new String("123");
        System.out.println(tmp1 == tmp2);
        System.out.println(tmp1.hashCode() == tmp2.hashCode());
        System.out.println(tmp1.hashCode());
        System.out.println(tmp2.hashCode());
        /*
        48690
48690
        * 1191747167
1094834071
        * */
        System.out.println(System.identityHashCode(tmp1) == System.identityHashCode(tmp2));
        System.out.println(System.identityHashCode(tmp1));
        System.out.println(System.identityHashCode(tmp2));
    }
}
