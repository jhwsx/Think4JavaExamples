package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/03
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        traverse(collection);
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        traverse(collection);
        Collections.addAll(collection, moreInts);
        traverse(collection);
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);
        traverse(list);
//        list.add(21); // 运行报错：UnsupportedOperationException，底层数组不支持增删
//        list.remove(16);// 运行报错：UnsupportedOperationException，底层数组不支持增删
    }

    private static void traverse(Collection<Integer> collection) {
        for (Integer integer : collection) {
            System.out.print(integer+", ");
        }
        System.out.println();
    }
}
