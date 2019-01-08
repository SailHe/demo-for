package practice.demo.test;

import practice.util.SecureHashStandard;

/**
 * Description: 无描述类<p>
 *
 * @Package: org.demo
 * @author: SailHe
 * @date: 2019/1/7 16:36
 */
public class SecurityTester {
    public static void main(String[] args) {
        SecureHashStandard s256;
        SecureHashStandard s512;
        s256 = new SecureHashStandard(SecureHashStandard.EnumSHAType.SHA_256);
        s512 = new SecureHashStandard(SecureHashStandard.EnumSHAType.SHA_512);
        String str = "a";
        System.out.println(s256.calcHashValue(str));
        System.out.println(s256.calcHashValue(str).equals(s256.calcHashValue(str)));

        System.out.println(s512.calcHashValue(str));
        System.out.println(s512.calcHashValue(str).equals(s512.calcHashValue(str)));
    }
}
