package annotations.ex04;

import net.mindview.atunit.Test;

import java.util.HashSet;

/**
 * 验证是否每个测试都会生成一个新的 testObject。
 * 是的。
 */
public class HashSetTest {
    HashSet<String> testObject = new HashSet<>();
    public static int count = 0;
    public int id = ++count;

    public HashSetTest() {
        System.out.println();
        System.out.println("Constructing HashSetTest #" + id);
    }

    @Test
    void initialization() {
        System.out.println("initialization(): HashSetTest #" + id);
        assert testObject.isEmpty();
    }

    @Test
    void _contains() {
        System.out.println("_contains(): HashSetTest #" + id);
        testObject.add("one");
        assert testObject.contains("one");
    }

    @Test
    void _remove() {
        System.out.println("_remove(): HashSetTest #" + id);
        testObject.add("one");
        testObject.remove("one");
        assert testObject.isEmpty();
    }
}