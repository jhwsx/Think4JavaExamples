package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/18
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ModifyingArraysAsList {
    public static void main(String[] args) {
        Random random = new Random(47);
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = new ArrayList<>(Arrays.asList(integers));
        System.out.println("Before shuffling: " + list);
        Collections.shuffle(list, random);
        System.out.println("After shuffling: " + list);
        System.out.println("array: " + Arrays.toString(integers));

        List<Integer> list2 = Arrays.asList(integers);
        System.out.println("Before shuffling: " + list2);
        Collections.shuffle(list2, random);
        System.out.println("After shuffling: " + list2);
        System.out.println("array: " + Arrays.toString(integers));
//        list2.remove(0); // 不支持移除
//        System.out.println("remove: " + list2);
//        list2.add(5); // 不支持添加
    }
}
