package holding.ex06;

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
    static List<String> total = new ArrayList<>();
    static {
        total.add("Apple");
        total.add("Pear");
        total.add("Peach");
        total.add("Banana");
        total.add("Orange");
        total.add("Watermelon");
        total.add("Pineapple");
        total.add("Litchi");
        total.add("Tomato");
    }
    public static List<String> listOfRandString(int length) {
        Random random = new Random(47);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(total.get(random.nextInt(total.size())));
        }
        return result;
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<String> pets = listOfRandString(7);
        System.out.println("1: " + pets);
        String h = "Cucumber";
        pets.add(h);
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.contains(h));
        pets.remove(h);
        String p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));
        String cymric = "Pear"; // 这里比较特殊，这个字符串直接在列表里移除了
        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.remove(cymric));
        System.out.println("pets: " + pets);
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);
        pets.add(3, "Rice");
        System.out.println("9: " + pets);
        List<String> sub = pets.subList(1, 4); //[1,4),返回的是一个SubList对象
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
        List<String> copy = new ArrayList<>(pets);
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
        copy.set(1, "Noodle");
        System.out.println("16: " + copy);
        copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + pets.isEmpty());
        pets.clear();
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());
        pets.addAll(Arrays.asList("Bread","Milk","Coffee","Butter"));
        System.out.println("21: " + pets);
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
        String[] pa = pets.toArray(new String[0]);
        System.out.println("23: " + pa[3]);
        String[] pa1 = pets.toArray(new String[pets.size() + 2]);
        System.out.println("24: " + Arrays.toString(pa1));
    }
}
