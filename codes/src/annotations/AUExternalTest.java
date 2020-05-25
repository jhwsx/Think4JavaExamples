package annotations;

import net.mindview.atunit.Test;

/**
 * @author wangzhichao
 * @since 2020/5/14
 */
public class AUExternalTest extends AtUnitExample1 {
    @Test
    boolean _MethodOne() {
        return methodOne().equals("This is methodOne");
    }
    @Test
    boolean _MethodTwo() {
        return methodTwo() == 2;
    }
}
