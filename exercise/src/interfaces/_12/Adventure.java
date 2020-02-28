package interfaces._12;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

interface CanClimb {
    void climb();
}

class ActionCharacter {
    public void fight() {
        System.out.println("fight(): " + this.getClass().getSimpleName());
    }
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly, CanClimb {

    @Override
    public void swim() {
        System.out.println("swim(): " + this.getClass().getSimpleName());

    }

    @Override
    public void fly() {
        System.out.println("fly(): " + this.getClass().getSimpleName());

    }

    @Override
    public void climb() {
        System.out.println("climb(): " + this.getClass().getSimpleName());

    }
}

public class Adventure {
    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void y(CanClimb x) {
        x.climb();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        t(hero);
        u(hero);
        v(hero);
        w(hero);
        y(hero);
    }
}
