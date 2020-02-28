package initialization;

/**
 * @author wzc
 * @date 2019/6/5
 */
public class MethodInit {
    int i = f();
    int f() {
        return 11;
    }

    public static void main(String[] args) {
        MethodInit methodInit = new MethodInit();
        System.out.println(methodInit.i);
    }
}
