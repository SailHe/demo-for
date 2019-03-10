package practice.demo.design.patterms;

import practice.demo.design.model.*;

/**
 * Description: 无描述类
 * <p>
 * Package practice.demo.design.patterms
 *
 * @author SailHe
 * @date 2019/3/10 9:51
 */
public class DefaultFactory extends AbstractFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }
}
