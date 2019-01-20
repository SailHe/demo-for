package practice.util;

/**
 * Description: 断言类
 * <p>
 * Package practice.util
 *
 * @author SailHe
 * @date 2019/1/20 22:52
 */
public class Assert {
    public static void isTrue(boolean ass, String msg) {
        if (!ass) {
            throw new AssertionError(msg);
        }
    }
}
