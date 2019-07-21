package access;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class Lunch {
    void testPrivate() {
//        Soup1 soup1 = new Soup1();
    }
    void testStatic() {
        Soup1 soup1 = Soup1.makeSoup();
    }
    void testSingleton() {
        Soup2.access().f();
    }
}

class Soup1 {
    private Soup1() {

    }

    public static Soup1 makeSoup() {
        return new Soup1();
    }
}

class Soup2 {
    private Soup2() {

    }

    private static Soup2 sSoup2 = new Soup2();

    public static Soup2 access() {
        return sSoup2;
    }

    public void f() {

    }
}
