package annotations.ex04;

import net.mindview.atunit.Test;

/**
 * @author wangzhichao
 * @since 2020/5/14
 */
public class AtUnitExample1 {
    public static int count = 0;
    private int id = ++count;

    public AtUnitExample1() {
        System.out.println();
        System.out.println("Constructing AtUnitExample1 #" + id);
    }

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @Test
    public boolean methodOneTest() {
        System.out.println("methodOneTest(): AtUnitExample1 #" + id);
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean m2() {
        System.out.println("m2(): AtUnitExample1 #" + id);
        return methodTwo() == 2;
    }

    @Test
    private boolean m3() {
        System.out.println("m3(): AtUnitExample1 #" + id);
        return true;
    }

    // Shows output for failure:
    @Test
    boolean failureTest() {
        System.out.println("failureTest(): AtUnitExample1 #" + id);
        return false;
    }

    @Test
    boolean anotherDisappointment() {
        System.out.println("anotherDisappointment(): AtUnitExample1 #" + id);
        return false;
    }
}
