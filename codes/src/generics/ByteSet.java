package generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wangzhichao
 * @since 2020/01/04
 */
public class ByteSet {
    public static void main(String[] args) {
        Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Set<Byte> mySet = new HashSet<>(Arrays.asList(possibles));
        System.out.println("mySet = " + mySet);
        // 下面这行编译错误：不能理解构造方法 HashSet(List<Integer>)，可以看一下构造方法
//        public HashSet(Collection<? extends E> c) {
        // 需要的是 Byte 或者 Byte 的子类
//        Set<Byte> mySet2 = new HashSet<Byte>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        // 下面这行编译也是错误的，为什么呢？
        // 需要的是 Byte 类型的元素，给我 Integer 类型的元素干什么呢？
//        Set<Byte> mySet3 = new HashSet(Arrays.<Byte>asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

}
