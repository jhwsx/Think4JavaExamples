package generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author wangzhichao
 * @since 2019/12/08
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random random = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        String[] splits = "The quick brown fox jumped over the lazy brown dog".split(" ");
        for (String s : splits) {
            randomList.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(randomList.select() + " ");
        }
    }
}
