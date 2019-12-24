package generics;

import java.util.List;

/**
 * @author wangzhichao
 * @since 2019/12/23
 */
// 超能力接口
interface SuperPower {}

interface XRayVision extends SuperPower {
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
    void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
    POWER power;
    SuperHero(POWER power) {
        this.power = power;
    }
    POWER getPower() {
        return power;
    }
}
// 超级侦探
class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {

    SuperSleuth(POWER power) {
        super(power);
    }
    void see() {
        power.seeThroughWalls();
    }
}
// 犬类英雄
class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {

    CanineHero(POWER power) {
        super(power);
    }
    void hear() {
        power.hearSubtleNoises();
    }

    void smell() {
        power.trackBySmell();
    }
}

class SuperHearSmell implements SuperHearing, SuperSmell {

    @Override
    public void hearSubtleNoises() {

    }

    @Override
    public void trackBySmell() {

    }
}

class DogBoy extends CanineHero<SuperHearSmell> {

    DogBoy() {
        super(new SuperHearSmell());
    }
}

public class EpicBattle {
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
    }

    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        superFind(dogBoy);
        // 这样写是好的
        List<? extends SuperHearing> audioBoys;
        // 这样写是不可以的，因为通配符?被限定为单一边界
//        List<? extends SuperHearing & SuperSmell> dogBoys;
    }

}
