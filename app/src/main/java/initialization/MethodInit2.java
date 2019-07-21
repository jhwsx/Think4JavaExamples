package initialization;

/**
 * @author wzc
 * @date 2019/6/5
 */
public class MethodInit2 {
    int i = f();
    int j = g(i);

    int f() {
        return 11;
    }

    int g(int n) {
        return n * 10;
    }

    public static void main(String[] args) {
        MethodInit2 methodInit2 = new MethodInit2();
        System.out.println(methodInit2.j);
    }
}
