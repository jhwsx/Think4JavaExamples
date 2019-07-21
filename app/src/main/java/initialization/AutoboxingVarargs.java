package initialization;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class AutoboxingVarargs {
    public static void main(String[] args) {
        f(new Integer(1),new Integer(2));
        f(2,3,4,5);
        f(6,new Integer(7),8);
    }

    static void f(Integer... args) {
        for (Integer i : args) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
