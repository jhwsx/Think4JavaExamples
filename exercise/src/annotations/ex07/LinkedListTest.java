package annotations.ex07;

import net.mindview.atunit.Test;

import java.util.LinkedList;

public class LinkedListTest extends LinkedList<String> {
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
