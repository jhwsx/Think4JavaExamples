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
public class Ex11 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Interface1 interface1 = outer.inner();
//        Inner interface11 = (Inner) interface1;
    }
}
