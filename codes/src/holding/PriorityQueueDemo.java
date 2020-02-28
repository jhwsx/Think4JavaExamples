package holding;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class PriorityQueueDemo {
    static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(random.nextInt(i + 10));
        }
        printQ(priorityQueue);
        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        printQ(priorityQueue);
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.<Integer>reverseOrder());
        priorityQueue.addAll(ints);
        printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<>(strings);
        printQ(stringPQ);
        stringPQ = new PriorityQueue<>(strings.size(), Collections.<String>reverseOrder());
        stringPQ.addAll(strings);
        printQ(stringPQ);

        Set<Character> characterSet = new HashSet<>();
        for (char c : fact.toCharArray()) {
            characterSet.add(c);
        }
        PriorityQueue<Character> charactersPQ = new PriorityQueue<>();
        charactersPQ.addAll(characterSet);
        printQ(charactersPQ);
    }
}
