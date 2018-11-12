package practice.game;

import practice.util.MyNumber;

import java.awt.*;

/**
 * Description: 生物类<p>
 *
 * @Package: practice.DemoGame
 * @author: SailHe
 * @date: 2018/5/29 12:37
 */
class Biology {
    /**
     * Descriptions: 仅人物继承使用<==>天赋<p>
     *
     * @author SailHe
     * @date 2018/11/11 18:45
     */
    int[] dna;
    int high, weight;
    int skin;
    int speed;
    Sex male = Sex.unknown;
    Point position;

    Biology() {
        //{VIT, INT, STR, LUK, AGI}
        dna = new int[5];
        for (int i = 0; i < 5; i++) {
            dna[i] = MyNumber.randomRange(0, 4);
        }
        this.male = Sex.values()[MyNumber.randomRange(0, 2)];
    }
}
