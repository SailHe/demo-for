package mypackage.util;

/**
 * Descriptions: Created by 魔诃不思议 on 2017/7/21.<p>
 *
 * @author SailHe
 * @date 2018/11/11 18:47
 */
public class MyString implements Comparable<MyString> {
    public char[] value;

    public MyString() {
    }

    public MyString(String value) {
        this.value = value.toCharArray();
    }

    public MyString(int lenMax) {
        value = new char[lenMax];
    }

    /**
     * Descriptions: 返回连续非零字符的长度<p>
     *
     * @author SailHe
     * @date 2018/11/11 18:47
     */
    int length() {
        int i;
        for (i = 0; this.value[i] != 0; i++) {
        }
        return i;
    }

    @Override
    public int compareTo(MyString o) {
        //String 的是char[]的length，含0
        int len1 = this.length();
        int len2 = o.length();
        int len = len1 < len2 ? len1 : len2;

        for (int i = 0; i < len; i++) {
            if (value[i] != o.value[i]) {
                return value[i] - o.value[i];
            }
        }
        return len1 - len2;
    }

    @Override
    public final String toString() {
        //char[]没有toString方法
        return new String(this.value, 0, this.length());
    }
}
