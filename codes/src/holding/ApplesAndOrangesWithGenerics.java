package holding;

import java.util.ArrayList;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/03
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ApplesAndOrangesWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
//        apples.add(new Orange()); // 此行编译报错
        for (int i = 0; i < apples.size(); i++) {
            System.out.println(apples.get(i).id());
        }
        for (Apple apple : apples) {
            System.out.println(apple.id());
        }
    }
}


