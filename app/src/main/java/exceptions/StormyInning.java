package exceptions;

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
    }
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
    public void event() throws RainedOut;

    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    // 可以给构造器添加新的异常，但必须先处理基类构造器的异常
    public StormyInning() throws RainedOut, BaseballException {
    }

    public StormyInning(String s) throws RainedOut, BaseballException {
        this();
    }

    // 常规方法必须和基类相符
//    @Override
//    public void walk() throws PopFoul{} // 不可以抛出基类方法没有抛出的异常

//    public void event() throws  BaseballException {} // 为什么这样写会报错

    public void event() {} // 这样写是对的，因为可以选择不抛任何异常，即便基类方法抛了

//    public void event() throws RainedOut {} // 接口不能给来自基类的方法添加异常

    public void rainHard() throws RainedOut {} // 接口可以给不在基类中的方法添加异常

    public void atBat() throws PopFoul {} // 覆写的方法可以抛继承的异常

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut rainedOut) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut rainedOut) {
            System.out.println("RainedOut");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        try {
            Storm storm = new StormyInning();
            storm.event();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        }
    }
}
