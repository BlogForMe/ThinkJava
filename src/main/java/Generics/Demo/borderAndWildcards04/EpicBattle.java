package Generics.Demo.borderAndWildcards04;

import java.util.List;

/**
 * Created by Jon on 2016/6/5.
 */

interface SuperPower {
}

interface XRayVision extends SuperPower {
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
    void hearSubtleBoises();
}

interface SuperSmell extends SuperPower {
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
    POWER power;

    public SuperHero(POWER power) {
        this.power = power;
    }

    POWER getPower() {
        return power;
    }
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {

    public SuperSleuth(POWER power) {
        super(power);
    }

    void see() {
        power.seeThroughWalls();
    }
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {

    public CanineHero(POWER power) {
        super(power);
    }

    void hear() {
        power.hearSubtleBoises();
    }

    void smell() {
        power.trackBySmell();
    }
}

class SuperHearSmell implements SuperHearing, SuperSmell {

    @Override
    public void hearSubtleBoises() {

    }

    @Override
    public void trackBySmell() {

    }
}

class DogBoy extends CanineHero<SuperHearSmell> {

    public DogBoy() {
        super(new SuperHearSmell());
    }
}

public class EpicBattle {
    //Bounds in generic methods:
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleBoises();
    }

    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleBoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);

        //You can do this:
        List<? extends SuperHearing> audioBoys;
        // but you can't do this:
//             List<? extends SuperHearing&SuperSmell> dogBoys;  限制为单一边界
    }
}
