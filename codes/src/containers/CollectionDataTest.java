package containers;

import net.mindview.util.CollectionData;
import net.mindview.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author wangzhichao
 * @since 2020/2/28
 */
class Government implements Generator<String> {
    String[] foundation = ("strange women lying in ponds " +
            "distributing swords is no basis for a system of " +
            "government").split(" ");
    private int index;
    @Override
    public String next() {
        return foundation[index++];
    }
}
public class CollectionDataTest {
    public static void main(String[] args) {
        // LinkedHashSet 是存取有序
        Set<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(), 15));
        System.out.println(set);
        System.out.println("--------------------------------");
        // 使用方便的泛型方法
        set.clear();
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}
