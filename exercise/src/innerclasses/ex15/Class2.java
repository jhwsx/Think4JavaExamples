package innerclasses.ex15;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Class2 {
    public Class1 get(String s) {
        return new Class1(s){};
    }

    public static void main(String[] args) {
        Class2 class2 = new Class2();
        Class1 class1 = class2.get("home");
        System.out.println(class1.getString());
    }
}
