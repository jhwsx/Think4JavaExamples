package annotations.ex09;

import net.mindview.atunit.Test;

import java.util.HashMap;

/**
 * @author wangzhichao
 * @since 2020/12/22
 */
public class HashMapTest extends HashMap<String, Integer> {
    @Test
    void _put() {
        put("one", 1);
        assert get("one") == 1;
    }

    @Test
    void _isEmpty() {
        assert isEmpty();
    }

    @Test
    void _get() {
        assert get("one") == null;
        put("one", 1);
        assert get("one") == 1;
    }
    @Test
    void _size() {
        put("one", 1);
        assert size() == 1;
        put("two", 2);
        assert size() == 2;
    }
    @Test
    void _containsKey() {
        assert containsKey("one") == false;
        put("one", 1);
        assert containsKey("one");
    }
}
