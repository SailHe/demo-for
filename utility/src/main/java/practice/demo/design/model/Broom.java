package practice.demo.design.patterns;

import practice.demo.design.model.Vehicle;

/**
 * Description: 扫帚
 * <p>
 * Package practice.demo.design.patterns
 *
 * @author SailHe
 * @date 2019/3/10 10:12
 */
public class Broom extends Vehicle {
    @Override
    public void run() {
        System.out.println("Broom Run!");
    }
}
