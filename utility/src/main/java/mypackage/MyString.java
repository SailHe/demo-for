package mypackage;

/**
 * Created by 魔诃不思议 on 2017/7/21.
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

    /* 返回连续非零字符的长度 */
    int length() {
        int i;
        for (i = 0; this.value[i] != 0; i++) ;
        return i;
    }

    /*String 的是char[]的length，含0*/
    public int compareTo(MyString o) {
        int len1 = this.length();
        int len2 = o.length();
        int len = len1 < len2 ? len1 : len2;

        for (int i = 0; i < len; i++) {
            if (value[i] != o.value[i])
                return value[i] - o.value[i];
        }
        return len1 - len2;
    }

    /* char[]没有toString方法 */
    public final String toString() {
        return new String(this.value, 0, this.length());
    }
}
