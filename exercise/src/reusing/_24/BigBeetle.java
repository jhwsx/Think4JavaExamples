package reusing._24;

/**
 * @author wzc
 * @date 2019/7/13
 */
class Inset {
    private int i = 9;
    protected int j;
    Inset() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("static Inset.x1 initialized");
    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

 class Beetle extends Inset{
    private int k = printInit("Beetle.k initialized");
    public Beetle() {
        System.out.println("j = " + j);
        System.out.println("k = " + k);
    }

    private static int x2 = printInit("static Beetle.x2 initialized");
}

public class BigBeetle extends Beetle {
    private int n = printInit("BigBeetle.n initialized");
    public BigBeetle() {
        System.out.println("n = " + n);
        System.out.println("j = " + j);
    }

    private static int x3 = printInit("static BigBeetle.x3 initialized");
    public static void main(String[] args) {
        System.out.println("BigBeetle constructor");
        BigBeetle bigBeetle = new BigBeetle();
    }
}

