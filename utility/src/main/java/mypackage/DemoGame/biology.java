package mypackage.DemoGame;

import mypackage.myNumber;

import java.awt.*;

/**
 * Description: 无描述类<p>
 *
 * @Package: mypackage.DemoGame
 * @author: SailHe
 * @date: 2018/5/29 12:37
 */
class biology {
    int[] dna;/* 仅人物继承使用<==>天赋 */
    int high, weight;
    int skin;
    int speed;
    sex male = sex.unknown;
    Point position;

    biology() {
        dna = new int[5];/*{VIT, INT, STR, LUK, AGI}*/
        for (int i = 0; i < 5; i++) {
            dna[i] = myNumber.randomRange(0, 4);
        }
        this.male = sex.values()[myNumber.randomRange(0, 2)];
    }
}
