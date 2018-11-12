package practice.game;

import practice.MyNumber_;

import java.awt.*;

/**
 * Description: 无描述类<p>
 *
 * @Package: mypackage.DemoGame
 * @author: SailHe
 * @date: 2018/5/29 12:37
 */
class biology {
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
    sex male = sex.unknown;
    Point position;

    biology() {
        //{VIT, INT, STR, LUK, AGI}
        dna = new int[5];
        for (int i = 0; i < 5; i++) {
            dna[i] = MyNumber_.randomRange(0, 4);
        }
        this.male = sex.values()[MyNumber_.randomRange(0, 2)];
    }
}
