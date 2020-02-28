package innerclasses.ex20;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   : 接口内的嵌套类
 *     version: 1.0
 * </pre>
 */
public interface Ex20 {
    void f();
    class Ex20Imp implements Ex20 {

        @Override
        public void f() {
            System.out.println("f()");
        }

        public static void main(String[] args) {
            Ex20 ex20 = new Ex20Imp();
            ex20.f();
        }
    }
}
