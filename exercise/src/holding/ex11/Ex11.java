package holding.ex11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Value implements Comparable{
    int i;

    Value(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Value " + i;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

public class Ex11 {
    static void tranverse(Iterator<Value> it) {
        while (it.hasNext()) {
            Value value = it.next();
            System.out.print(value+", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Value> values = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            values.add(new Value(i));
        }
        LinkedList<Value> valueLinkedList = new LinkedList<>(values);
        HashSet<Value> valueHashSet = new HashSet<>(values);
//        TreeSet<Value> valueTreeSet = new TreeSet<>(values);
        LinkedHashSet<Value> valueLinkedHashSet = new LinkedHashSet<>(values);
        tranverse(values.iterator());
        tranverse(valueLinkedList.iterator());
        tranverse(valueHashSet.iterator());
//        tranverse(valueTreeSet.iterator());
        tranverse(valueLinkedHashSet.iterator());
    }
}
