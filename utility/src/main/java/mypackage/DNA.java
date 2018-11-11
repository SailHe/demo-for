package mypackage;

/**
 * Descriptions: Created by 魔诃不思议 on 2017/7/20.<p>
 *
 * @author SailHe
 * @date 2018/11/11 18:46
 */
class DNA implements Comparable<DNA> {
    String s;
    public int value;

    DNA(String s) {
        this.s = s;
        for (int i = 0; i < s.length(); i++) {
            for (char cc : s.substring(i + 1).toCharArray()) {
                value += s.charAt(i) > cc ? 1 : 0;
            }
        }
    }

    /* 实现接口 */
    @Override
    public int compareTo(DNA o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return s;
    }
}
