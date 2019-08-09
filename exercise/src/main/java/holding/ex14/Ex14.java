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
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ListIterator<Integer> listIterator = linkedList.listIterator(linkedList.size() / 2);
            listIterator.add(i);

        }
        System.out.println(linkedList);
    }
}
