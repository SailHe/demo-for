package practice.demo.design.patterms;

/**
 * Description: 无描述类
 * <p>
 * Package practice.demo.design.patterms
 *
 * @author SailHe
 * @date 2019/3/10 9:51
 */

import practice.demo.design.model.Food;
import practice.demo.design.model.Vehicle;
import practice.demo.design.model.Weapon;

/**
 * Descriptions: <抽象工厂模式>声明创建抽象产品对象的操作接口<p>
 *
 * @author Unknown||Hidden
 * @date 2019/3/10 9:48
 */
public abstract class AbstractFactory {
    /**
     * Descriptions: 创建Vehicle<p>
     *
     * @author Unknown||Hidden
     * @date 2019/3/10 10:02
     * @return Vehicle
     */
    public abstract Vehicle createVehicle();

    /**
     * Descriptions: 创建 Weapon<p>
     *
     * @author Unknown||Hidden
     * @date 2019/3/10 10:04
     * @return Weapon
     */
    public abstract Weapon createWeapon();

    /**
     * Descriptions: 创建Food<p>
     *
     * @author Unknown||Hidden
     * @date 2019/3/10 10:04
     * @return Food
     */
    public abstract Food createFood();
}
