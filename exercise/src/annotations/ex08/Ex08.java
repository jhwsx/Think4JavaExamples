package annotations.ex08;

import net.mindview.atunit.TestProperty;

/**
 * @author wangzhichao
 * @since 2020/12/22
 */
public class Ex08 {
    public String method1() {
        return "method1()";
    }

    private String method2() {
        return "method2()";
    }

    @TestProperty
    String testMethod2() {
        return method2();
    }
}
