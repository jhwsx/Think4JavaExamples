package typeinfo.ex11;


import java.util.HashMap;

import typeinfo.ex11.pets.Cat;
import typeinfo.ex11.pets.Cymric;
import typeinfo.ex11.pets.Dog;
import typeinfo.ex11.pets.EgyptianMau;
import typeinfo.ex11.pets.ForNameCreator;
import typeinfo.ex11.pets.Gerbil;
import typeinfo.ex11.pets.Hamster;
import typeinfo.ex11.pets.Manx;
import typeinfo.ex11.pets.Mouse;
import typeinfo.ex11.pets.Mutt;
import typeinfo.ex11.pets.Pet;
import typeinfo.ex11.pets.PetCreator;
import typeinfo.ex11.pets.Pug;
import typeinfo.ex11.pets.Rat;
import typeinfo.ex11.pets.Rodent;

/**
 * 跟踪不同类型的 Pet 的数量的工具
 *
 * @author wangzhichao
 * @date 2019/11/30
 */
public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet) {
                counter.count("Pet");
            }
            if (pet instanceof Dog) {
                counter.count("Dog");
            }
            if (pet instanceof Mutt) {
                counter.count("Mutt");
            }
            if (pet instanceof Pug) {
                counter.count("Pug");
            }
            if (pet instanceof Cat) {
                counter.count("Cat");
            }
            if (pet instanceof EgyptianMau) {
                counter.count("EgyptianMau");
            }
            if (pet instanceof Manx) {
                counter.count("Manx");
            }
            if (pet instanceof Cymric) {
                counter.count("Cymric");
            }
            if (pet instanceof Rodent) {
                counter.count("Rodent");
            }
            if (pet instanceof Rat) {
                counter.count("Rat");
            }
            if (pet instanceof Mouse) {
                counter.count("Mouse");
            }
            if (pet instanceof Hamster) {
                counter.count("Hamster");
            }
            if (pet instanceof Gerbil) {
                counter.count("Gerbil");
            }
        }

        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
