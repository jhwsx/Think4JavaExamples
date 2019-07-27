package innerclasses.ex21;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public interface In {
    int g();
    class NestClass {
        public static void f(In in) {
            System.out.println(in.g());
        }
    }
}
