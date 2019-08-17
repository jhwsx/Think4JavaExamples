package holding.ex29;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Simple {}
public class Ex29 {
    public static void main(String[] args) {
        List<Simple> list = new ArrayList<>();
        list.add(new Simple());
        list.add(new Simple());
        list.add(new Simple());
        list.add(new Simple());
        list.add(new Simple());
        PriorityQueue<Simple> simplePriorityQueue = new PriorityQueue<>(list);
        printQ(simplePriorityQueue);
    }

    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}
/*
    Exception in thread "main" java.lang.ClassCastException: holding.ex29.Simple cannot be cast to java.lang.Comparable
        at java.util.PriorityQueue.siftDownComparable(PriorityQueue.java:694)
        at java.util.PriorityQueue.siftDown(PriorityQueue.java:689)
        at java.util.PriorityQueue.heapify(PriorityQueue.java:736)
        at java.util.PriorityQueue.initFromCollection(PriorityQueue.java:275)
        at java.util.PriorityQueue.<init>(PriorityQueue.java:202)
        at holding.ex29.Ex29.main(Ex29.java:26)
*/