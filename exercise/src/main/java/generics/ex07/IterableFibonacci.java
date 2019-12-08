package generics.ex07;

import androidx.annotation.NonNull;

import java.util.Iterator;

/**
 * 实现了 Iterable 的 Fibonacci 生成器
 * 使用组合代替继承，适配 Fibonacci 使其成为 Iterable
 *
 * @author wangzhichao
 * @since 2019/12/08
 */
public class IterableFibonacci extends Fibonacci {

    private int size;

    public IterableFibonacci(int size) {
        this.size = size;
    }

    public Iterable<Integer> iterable = new Iterable<Integer>() {
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
    };

    public static void main(String[] args) {
        for (Integer i : new IterableFibonacci(18).iterable) {
            System.out.print(i + " ");
        }
    }
}
