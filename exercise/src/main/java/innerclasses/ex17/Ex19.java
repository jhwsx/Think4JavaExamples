package innerclasses.ex17;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface Toss {
    void toss();
}

interface TossFactory {
    Toss getToss();
}

class CoinToss implements Toss {

    private CoinToss() {
    }
    @Override
    public void toss() {
        System.out.println("CoinToss toss()");
    }

    public static TossFactory factory = new TossFactory() {
        @Override
        public Toss getToss() {
            return new CoinToss();
        }
    };
}

//class CoinTossFactory implements TossFactory {
//    @Override
//    public Toss getToss() {
//        return new CoinToss();
//    }
//}

class DiceToss implements Toss {
    private DiceToss() {
    }
    @Override
    public void toss() {
        System.out.println("DiceToss toss()");
    }
    public static TossFactory factory = new TossFactory() {
        @Override
        public Toss getToss() {
            return new DiceToss();
        }
    };
}

//class DiceTossFactory implements TossFactory {
//    @Override
//    public Toss getToss() {
//        return new DiceToss();
//    }
//}

public class Ex19 {
    static void playToss(TossFactory factory) {
        Toss toss = factory.getToss();
        toss.toss();
    }

    public static void main(String[] args) {
//        playToss(new CoinTossFactory());
//        playToss(new DiceTossFactory());
        playToss(CoinToss.factory);
        playToss(DiceToss.factory);
    }
}
