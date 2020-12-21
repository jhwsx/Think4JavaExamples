package annotations.ex05;

import net.mindview.atunit.Test;

import java.util.HashSet;

public class HashSetTest extends HashSet<String> {
    @Test
    void initialization() {
        assert isEmpty();
    }

    @Test
    void _contains() {
        add("one");
        assert contains("one");
    }

    @Test
    void _remove() {
        add("one");
        remove("one");
        assert isEmpty();
    }
}
