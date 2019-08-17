package holding.ex28;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ex28 {
    public static void main(String[] args) {
        Random random = new Random(47);
        PriorityQueue<Double> doublePriorityQueue = new PriorityQueue<>(5);
        for (int i = 0; i < 5; i++) {
            doublePriorityQueue.offer(random.nextDouble());
        }
        printQ(doublePriorityQueue);
    }

    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}
