package innerclasses.ex11;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Outer {
    private class Inner implements Interface1{

        @Override
        public void f() {
            System.out.println("Inner.f()");
        }
    }

    Interface1 inner() {
        return new Inner();
    }


}
