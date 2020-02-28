package initialization;

/**
 * @author wzc
 * @date 2019/6/5
 */
public class MethodInit3 {
//    int j = g(i); // 此行报错：Illegal forward reference.
    int i = f();

    int f() {
        return 11;
    }

    int g(int n) {
        return n * 10;
    }

    public static void main(String[] args) {
        MethodInit3 methodInit2 = new MethodInit3();
//        System.out.println(methodInit2.j);
    }
}
