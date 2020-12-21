package annotations.ex08;

import net.mindview.atunit.Test;

/**
 * @author wangzhichao
 * @since 2020/12/22
 */
public class Ex08Test extends Ex08 {
    @Test
    void _method1() {
        assert method1().equals("method1()");
    }

    @Test
    void _testMethod2() {
        assert testMethod2().equals("method2()");
    }
}
