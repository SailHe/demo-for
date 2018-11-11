package mypackage;

import java.util.Scanner;

/**
 * 分数类
 * Created by 魔诃不思议 on 2017/7/10.
 */
public class Fraction {
    /**
     * 分子
     */
    private double up = 0;
    /**
     * 分母
     */
    private double dw = 0;

    public Fraction(Scanner cin) {
        up = cin.nextDouble();
        dw = cin.nextDouble();
    }

    public Fraction(int up, int dw) {
        this.up = up;
        this.dw = dw;
    }

    public Fraction(double up, double dw) {
        this.up = up;
        this.dw = dw;
    }

    public static Fraction ZERO() {
        return new Fraction(0, 1);
    }

    static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    public double getUp() {
        return up;
    }

    public void setUp(double up) {
        this.up = up;
    }

    public double getDw() {
        return dw;
    }

    public void setDw(double dw) {
        this.dw = dw;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void plash(Fraction a) {
        this.up *= a.dw;
        //a.up *= this.dw;
        this.up += a.up * this.dw;
        this.dw *= a.dw;
    }

    public void toSimple() {
        /**公倍数*/
        int Ga = gcd((int) this.up, (int) this.dw);
        this.up /= Ga;
        this.dw /= Ga;
    }

    public double toDouble() throws Exception {
        if (dw == 0)
            throw new Exception();
        return this.up / this.dw;
    }
}
