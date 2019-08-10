package holding.ex14;

import java.util.LinkedList;
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
public class Ex14 {

    private static void addMiddle(LinkedList<Integer> l, Integer[] ia) {
        for (Integer i : ia) {
            ListIterator<Integer> it = l.listIterator(l.size() / 2);
            it.add(i);
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> li = new LinkedList<>();
        Integer[] x = {0, 1, 2, 3, 4, 5, 6, 7};
        Ex14.addMiddle(li, x);
    }
}
