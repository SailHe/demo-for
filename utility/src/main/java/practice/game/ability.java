package practice.game;

import java.awt.*;

/**
 * Description: 接口定义行为<p>
 *
 * @Package: mypackage.DemoGame
 * @author: SailHe
 * @date: 2018/5/29 12:37
 */
interface ability<T> {
    Point walk(T o);

    Point run();

    int attack(biology op);

    int defend(biology op);
}
