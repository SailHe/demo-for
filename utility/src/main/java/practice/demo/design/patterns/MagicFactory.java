package practice.demo.design.patterms;

import practice.demo.design.model.Food;
import practice.demo.design.model.Vehicle;
import practice.demo.design.model.Weapon;

/**
 * Description: 无描述类
 * <p>
 * Package practice.demo.design.patterms
 *
 * @author SailHe
 * @date 2019/3/10 9:52
 */
public class MagicFactory extends AbstractFactory {
    @Override
    public Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    public Food createFood() {
        return new Mushroom();
    }
}
