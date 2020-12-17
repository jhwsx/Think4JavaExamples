package annotations;

import net.mindview.atunit.Test;

/**
 * 使用继承的办法，来达到不把测试方法嵌入到原本的类中，仍然可以测试的目的。
 *
 * @author wangzhichao
 * @since 2020/5/14
 */
public class AtUnitExternalTest extends AtUnitExample1 {
    @Test
    boolean _methodOne() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return methodTwo() == 2;
    }
}
