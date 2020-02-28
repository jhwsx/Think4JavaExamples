package access._04;

import access._04.pp.BaseClass;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class ClassA extends BaseClass {

    void p() {
        f(); // protected
    }
    public static void main(String[] args) {
        ClassA X = new ClassA();
        X.p();
    }
}
