package typeinfo.ex11;


import net.mindview.util.TypeCounter;

import typeinfo.ex11.pets.Pet;
import typeinfo.ex11.pets.Pets;

/**
 * @author wangzhichao
 * @date 2019/11/30
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
