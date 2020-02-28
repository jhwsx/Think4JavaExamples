package arrays;

import net.mindview.util.Generated;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Arrays.sort 使用自己编写的 Comparator
 *
 * @author wzc
 * @date 2020/2/19
 */
class CompTypeComparator implements Comparator<CompType> {

    @Override
    public int compare(CompType o1, CompType o2) {
        return (o1.j < o2.j ? -1 : o1.j == o2.j ? 0 : 1);
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        System.out.println("before sorting");
        System.out.println(Arrays.toString(a));
        System.out.println("after sorting");
        Arrays.sort(a, new CompTypeComparator());
        System.out.println(Arrays.toString(a));
    }
}
