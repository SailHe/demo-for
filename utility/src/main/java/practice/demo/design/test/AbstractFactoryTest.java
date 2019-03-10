package practice.demo.design;

import practice.demo.design.model.Food;
import practice.demo.design.model.Vehicle;
import practice.demo.design.model.Weapon;
import practice.demo.design.patterns.AbstractFactory;
import practice.demo.design.patterns.DefaultFactory;

/**
 * Description: 无描述类
 * <p>
 * Package practice.demo.mo
 *
 * @author Unknown||Hidden
 * @date 2019/3/10 9:43
 */
public class DesignPatternsTest {
    public static void main(String[] args) {
        //only changes here to MagicFactory();
        AbstractFactory f = new DefaultFactory();
        Vehicle v = f.createVehicle();
        v.run();
        Weapon w = f.createWeapon();
        w.shoot();
        Food a = f.createFood();
        a.printName();
    }
}
