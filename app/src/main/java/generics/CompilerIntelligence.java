package generics;


import java.util.Arrays;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2019/12/27
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Fruit fruit = flist.get(0);
        System.out.println(fruit); // generics.Apple@1540e19d
        try {
            Apple a = (Apple) flist.get(0); // 不會報異常，也沒有警告
        } catch (Exception e) {
            System.out.println(e);
        }
        // 不可以添加 PECS 原則
//        flist.add(new Apple());

        flist.contains(new Apple()); // 參數是 Object 類型的

        flist.indexOf(new Apple()); // 參數是 Object 類型的

    }
}
