package innerclasses.ex06.pkg2;

import innerclasses.ex06.pkg1.Interface1;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Class1 {
    protected class Interface1Imp implements Interface1 {
        // 这里必须有 public 的构造方法，否则外部无法创建对象
        public Interface1Imp() {}
        @Override
        public void f() {
            System.out.println("Interface1Imp.f()");
        }
    }
}
