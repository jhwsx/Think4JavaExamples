package annotations;

import net.mindview.atunit.Test;

/**
 * 用于测试泛型类 {@link StackL},采用的是继承的办法
 *
 * @author wangzhichao
 * @since 2020/12/22
 */
public class StackLStringTest extends StackL<String> {
    @Test
    void _push() {
        push("one");
        assert top().equals("one");
        push("two");
        assert top().equals("two");
    }

    @Test
    void _pop() {
        push("one");
        push("two");
        assert pop().equals("two");
        assert pop().equals("one");
    }

    @Test
    void _top() {
        push("A");
        assert top().equals("A");
        push("B");
        assert top().equals("B");
    }
}
