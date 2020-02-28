//: typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.
package typeinfo.pets;

import java.util.*;

/**
 * 这里是创建一个使用了 LiteralPetCreator 的外观
 */
public class Pets {
    public static final PetCreator creator =
            new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
} ///:~
