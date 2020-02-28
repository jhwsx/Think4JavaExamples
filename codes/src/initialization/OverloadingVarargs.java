package initialization;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class OverloadingVarargs {
    static void f(Character... args) {
        System.out.print("first");
        for (Character character : args) {
            System.out.print(" " + character);
        }
        System.out.println();
    }

    static void f(Integer... args) {
        System.out.print("second");
        for (Integer integer : args) {
            System.out.print(" " + integer);
        }
        System.out.println();
    }

    static void f(Long... args) {
        System.out.print("third");
        for (Long l : args) {
            System.out.print(" " + l);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        f('a', 'b', 'c');
        f(1);
        f(2, 1);
        f(0);
        f(0L);
//        f(); // ambiguous method call
    }
}
