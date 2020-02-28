package initialization._19;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class VarargsTest {
    public static void main(String[] args) {
        f("a", "b", "c");
        f(new String[]{"A","B","C"});
    }

    static void f(String... args) {
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }
}
