package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class DotNew {
    public class Inner {}

    public static void main(String[] args) {
        DotNew dotNew = new DotNew();
        Inner inner = dotNew.new Inner();
    }
}
