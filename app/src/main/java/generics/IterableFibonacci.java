package generics;

import androidx.annotation.NonNull;

import java.util.Iterator;

/**
 * 实现了 Iterable 的 Fibonacci 生成器
 *
 * @author wangzhichao
 * @since 2019/12/08
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int size;

    public IterableFibonacci(int size) {
        this.size = size;
    }

    @NonNull
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int count = size;
            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Integer next() {
                count--;
                return IterableFibonacci.this.next();
            }
        };
    }

    public static void main(String[] args) {
        for (Integer i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }
}
