package innerclasses.ex23;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/28
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class A {
    U makeU() {
        return new U() {
            @Override
            public void f() {
                System.out.println("f()");
            }

            @Override
            public void g() {
                System.out.println("g()");
            }

            @Override
            public String toString() {
                return "I am a U";
            }
        };
    }
}
