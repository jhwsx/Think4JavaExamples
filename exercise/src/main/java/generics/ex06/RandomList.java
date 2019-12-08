package generics.ex06;

import java.util.ArrayList;
import java.util.Random;

import pets.Pet;
import pets.Pets;

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
        RandomList<Integer> randomList = new RandomList<>();
        for (int i = 0; i < 11; i++) {
            randomList.add(i);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(randomList.select() + " ");
        }
        System.out.println();
        RandomList<Pet> petRandomList = new RandomList<>();
        for (int i = 0; i < 11; i++) {
            petRandomList.add(Pets.randomPet());
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(petRandomList + " ");
        }
    }
}
