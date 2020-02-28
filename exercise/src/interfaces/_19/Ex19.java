package interfaces._19;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/21
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
    @Override
    public void toss() {
        System.out.println("CoinToss toss()");
    }
}

class CoinTossFactory implements TossFactory {
    @Override
    public Toss getToss() {
        return new CoinToss();
    }
}

class DiceToss implements Toss {
    @Override
    public void toss() {
        System.out.println("DiceToss toss()");
    }
}

class DiceTossFactory implements TossFactory {
    @Override
    public Toss getToss() {
        return new DiceToss();
    }
}

public class Ex19 {
    static void playToss(TossFactory factory) {
        Toss toss = factory.getToss();
        toss.toss();
    }

    public static void main(String[] args) {
        playToss(new CoinTossFactory());
        playToss(new DiceTossFactory());
    }
}
