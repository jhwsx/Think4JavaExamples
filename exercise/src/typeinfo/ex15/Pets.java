package typeinfo.ex15;

import java.util.ArrayList;

/**
 * 这是一个使用了 PetCreator 的外观
 */
public class Pets {
    public static final PetCreator creator =
            new PetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }

    public static void main(String[] args) {
        System.out.println(Pets.randomPet());
        System.out.println(Pets.arrayList(20));
    }
}
