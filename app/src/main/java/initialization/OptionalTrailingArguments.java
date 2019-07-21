package initialization;

/**
 * @author wzc
 * @date 2019/6/11
 */
public class OptionalTrailingArguments {
    public static void main(String[] args) {
        f(1, "one");
        f(2, "one", "two");
        f(0);
    }

    static void f(int required, String... trailing) {
        System.out.print("required: " + required + " ");
        for (String s : trailing) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
