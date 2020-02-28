package holding.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex12 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // 1
        List<Integer> list1 = new ArrayList<>(list.size());
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            list1.add(list1.size() - 1 - listIterator.previousIndex(), listIterator.next());
        }
        System.out.println(list1);
        // 2
        List<Integer> list2 = new ArrayList<>(list.size());
        ListIterator<Integer> listIterator1 = list.listIterator(list.size());
        while (listIterator1.hasPrevious()) {
            Integer previous = listIterator1.previous();
            list2.add(previous);
        }
        System.out.println(list2);
    }
}
