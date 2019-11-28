package typeinfo;

import java.util.Random;

/**
 * @author wangzhichao
 * @date 2019/11/28
 */
class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 =
            ClassInitialization.random.nextInt(100);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNotFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNotFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}
public class ClassInitialization {
    public static Random random = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization
        System.out.println(Initable.staticFinal);
        // Does trigger initialization
        System.out.println(Initable.staticFinal2);
        // Does trigger initialization
        System.out.println(Initable2.staticNotFinal);
        Class initable3 = Class.forName("typeinfo.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNotFinal);
    }
}
