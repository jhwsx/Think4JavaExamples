package holding.ex07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class MyClass {
    int value;

    MyClass(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyClass " + value;
    }
}
public class Ex07 {
    public static void main(String[] args) {
        MyClass[] myClasses = {
                new MyClass(1),
                new MyClass(2),
                new MyClass(3),
                new MyClass(4),
                new MyClass(5),
                new MyClass(6)
        };
        List<MyClass> myClassList = Arrays.asList(myClasses);
        System.out.println("1: " + myClassList);
        List<MyClass> subList = myClassList.subList(2, 4);
        System.out.println("2: " + subList);
//        subList.clear(); // 直接清除子集，会抛异常：不支持操作异常
//        System.out.println("3: " + subList);
//        myClassList.removeAll(subList); // 从集合中删除，抛异常：不支持操作异常
//        System.out.println("4: " + myClassList);

        List<MyClass> list = new ArrayList<>(myClassList);
        System.out.println("5: " + list);
        List<MyClass> subList1 = list.subList(2, 4);
        System.out.println("6: " + subList1);
        // 方法一：
//        subList1.clear();
//        System.out.println("7: " + subList1);
//        System.out.println("8: " + list);
        // 方法二：
//        list.removeAll(subList1); // 抛出并发修改异常
//        System.out.println("9: " + subList1);
//        System.out.println("10: " + list);
        // 方法三：
        List<MyClass> copy = new ArrayList<>(list);
        copy.removeAll(subList1);
        System.out.println("10: " + subList1);
        list = copy;
        System.out.println("11: " + list);
    }
}
