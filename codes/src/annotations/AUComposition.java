package annotations;

import net.mindview.atunit.Test;

/**
 * 利用组合来创建非嵌入式的测试
 * @author wangzhichao
 * @since 2020/5/14
 */
public class AUComposition {
    AtUnitExample1 testObject = new AtUnitExample1();
    @Test
    boolean tMethodOne() {
        return testObject.methodOne()
                .equals("This is methodOne");
    }

    @Test
    boolean tMethodTwo() {
        return testObject.methodTwo() == 2;
    }
}
