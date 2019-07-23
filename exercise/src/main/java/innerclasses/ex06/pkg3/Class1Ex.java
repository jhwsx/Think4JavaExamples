package innerclasses.ex06.pkg3;

import innerclasses.ex06.pkg1.Interface1;
import innerclasses.ex06.pkg2.Class1;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Class1Ex extends Class1 {
    Interface1 getImp() {
        return this.new Interface1Imp();
    }

    public static void main(String[] args) {
        Class1Ex class1Ex = new Class1Ex();
        Interface1 imp = class1Ex.getImp();
        imp.f();
    }
}
