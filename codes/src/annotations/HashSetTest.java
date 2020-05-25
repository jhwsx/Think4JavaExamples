package annotations;

import net.mindview.atunit.Test;

import java.util.HashSet;

/**
 * 使用断言的非嵌入式的例子
 *
 * @author wangzhichao
 * @since 2020/5/14
 */
public class HashSetTest {
    HashSet<String> testObject = new HashSet<>();

    @Test
    void initialization() {
        assert testObject.isEmpty();
    }
    @Test
    void _Contains() {
        testObject.add("one");
        assert testObject.contains("one");
    }

    @Test
    void _Remove() {
        testObject.add("one");
        testObject.remove("one");
        assert testObject.isEmpty();
    }
}
