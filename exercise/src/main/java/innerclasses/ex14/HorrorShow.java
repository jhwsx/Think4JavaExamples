package innerclasses.ex14;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

//class DragonZilla implements DangerousMonster {
//
//    @Override
//    public void menace() {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

//class VeryBadVampire implements Vampire {
//
//    @Override
//    public void menace() {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public void kill() {
//
//    }
//
//    @Override
//    public void drinkBlood() {
//
//    }
//}

public class HorrorShow {
    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public DangerousMonster monsterMaker() {
        return new DangerousMonster() {
            @Override
            public void destroy() {

            }

            @Override
            public void menace() {

            }
        };
    }

    public Vampire vampireMaker() {
        return new Vampire() {
            @Override
            public void drinkBlood() {

            }

            @Override
            public void destroy() {

            }

            @Override
            public void kill() {

            }

            @Override
            public void menace() {

            }
        };
    }
    public static void main(String[] args) {
        HorrorShow horrorShow = new HorrorShow();
        DangerousMonster barney = horrorShow.monsterMaker();
        u(barney);
        v(barney);
        Vampire vlad = horrorShow.vampireMaker();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}
