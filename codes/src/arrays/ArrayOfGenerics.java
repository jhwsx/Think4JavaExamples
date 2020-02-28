package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 创建非泛型的数组，然后将其转型为泛型数组的引用
 * @author wzc
 * @date 2020/1/30
 */
public class ArrayOfGenerics {
    @SuppressWarnings("unchecked cast")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        // Unchecked warning
        ls = (List<String>[]) la;
        ls[0] = new ArrayList<String>();
        System.out.println(ls);
        System.out.println(Arrays.toString(ls));
        // 编译报错：类型不匹配
//        ls[1] = new ArrayList<Integer>();
        // 这里使用 Object[] 引用指向了 ls，实际还是 List[] 类型的。
        Object[] objects = ls;
        objects[1] = new ArrayList<Integer>();
        // 此行运行报错：java.lang.ArrayStoreException: java.lang.Integer
        // objects[2] = 5;
        System.out.println(objects);
        System.out.println(Arrays.toString(objects));

        List<BerylliumSphere>[] spheres =
                (List<BerylliumSphere>[]) new List[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new ArrayList<BerylliumSphere>();
        }
    }
}
