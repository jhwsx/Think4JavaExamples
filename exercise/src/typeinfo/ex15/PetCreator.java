package typeinfo.ex15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import typeinfo.ex15.factory.Factory;

/**
 * 这是使用注册工厂实现的 PetCreator
 *
 * @author wangzhichao
 * @date 2019/11/30
 */
public class PetCreator {

    static List<Factory<? extends Pet>> petFactories = new ArrayList<>();

    static {
        petFactories.add(new Cat.Factory());
        petFactories.add(new Cymric.Factory());
        petFactories.add(new Dog.Factory());
        petFactories.add(new EgyptianMau.Factory());
        petFactories.add(new Hamster.Factory());
        petFactories.add(new Manx.Factory());
        petFactories.add(new Mouse.Factory());
        petFactories.add(new Mutt.Factory());
        petFactories.add(new Pet.Factory());
        petFactories.add(new Pug.Factory());
        petFactories.add(new Rat.Factory());
        petFactories.add(new Rodent.Factory());
    }

    private static Random rand = new Random(47);

    public Pet randomPet() {
        int n = rand.nextInt(petFactories.size());
        return petFactories.get(n).create();
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
