package practice.game;

import java.awt.*;

/**
 * Description: 接口定义行为<p>
 *
 * @Package: practice.DemoGame
 * @author: SailHe
 * @date: 2018/5/29 12:37
 */
interface Ability<T> {
    Point walk(T o);

    Point run();

    int attack(Biology op);

    int defend(Biology op);
}
