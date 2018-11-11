package mypackage.DemoGame;

import mypackage.myNumber;

public class human extends biology {
    private int VIT;//耐力--微增魔限   微增魔/物防(def) 血(hp)
    private int INT;//智力--魔限(mp)   魔攻(matk) 魔防(mdef)
    private int STR;//力量--物攻(atk)  物防      微增魔攻
    private int LUK;//运气--暴击(cri)  命中(hit)  闪避(dex)
    private int AGI;//敏捷--行走v     攻速v      闪避
    private int SP;/* skill point */
    private int ID;

    human(int id) {
        super();
        initialize();
        ID = id;
    }

    /* 洗点 ing*/
    private void initialize() {
        this.VIT = super.dna[0];
        this.INT = this.dna[1];
        this.STR = this.dna[2];
        this.AGI = this.dna[3];
        this.LUK = this.dna[4];
    }

    void Special(int prob) {
        if (myNumber.randomRange(1, prob) == 5) {
            this.VIT = 1;
            this.INT = 5;
            this.LUK = 5;
            this.STR = 0;
            System.out.println("命运法师");
        }
    }

    @Override
    public String toString() {
        return "人物" + ID + "   VIT:" + this.VIT + " INT" + this.INT + " STR" + STR + " LUK" + LUK + " AGI:" + AGI;
    }
}

