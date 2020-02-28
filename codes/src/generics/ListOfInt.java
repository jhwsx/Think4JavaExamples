package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2020/01/04
 */
public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            li.add(i);
        }
        for (int i : li) {
            System.out.print(i + " ");
        }
    }
}
