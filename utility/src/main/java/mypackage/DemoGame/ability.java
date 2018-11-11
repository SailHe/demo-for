package mypackage.DemoGame;

import java.awt.*;

/**
 * Description: 无描述类<p>
 *
 * @Package: mypackage.DemoGame
 * @author: SailHe
 * @date: 2018/5/29 12:37
 */ /*接口定义行为*/
interface ability<T> {
    Point walk(T o);

    Point run();

    int attack(biology op);

    int defend(biology op);
}
