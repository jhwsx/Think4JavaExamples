package holding.ex05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        ArrayList<Integer> pets = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            pets.add(i);
        }
        System.out.println("1: " + pets);
        Integer h = new Integer(7);
        pets.add(h);
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.contains(h));
        pets.remove(h);
        Integer p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));
        Integer cymric = new Integer(8);
        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.remove(cymric));
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);
        pets.add(3, 9);
        System.out.println("9: " + pets);
        List<Integer> sub = pets.subList(1, 4); //[1,4),返回的是一个SubList对象
        System.out.println("subList: " + sub);
        System.out.println("10: " + pets.containsAll(sub));
        Collections.sort(sub);
        System.out.println("pets: " + pets); // 对 sublist 进行 sort，shuffle，竟然可以影响到 pets
        System.out.println("sorted subList: " + sub);
        System.out.println("11: " + pets.containsAll(sub)); // 一个一个遍历看是否都包含
        Collections.shuffle(sub, rand);
        System.out.println("pets: " + pets); // 对 sublist 进行 sort，shuffle，竟然可以影响到 pets
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + pets.containsAll(sub)); // 一个一个遍历看是否都包含
        List<Integer> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub); // 保留 sub 中的内容，删除其他的内容
        System.out.println("13: " + copy);
        System.out.println("pets: " + pets);
        copy = new ArrayList<>(pets);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        copy.set(1, new Integer(10));
        System.out.println("16: " + copy);
        copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + pets.isEmpty());
        pets.clear();
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());
        pets.addAll(Arrays.asList(1,2,3,4));
        System.out.println("21: " + pets);
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
        Integer[] pa = pets.toArray(new Integer[0]);
        System.out.println("23: " + pa[3]);
        Integer[] pa1 = pets.toArray(new Integer[pets.size() + 2]);
        System.out.println("24: " + Arrays.toString(pa1));
    }
}
