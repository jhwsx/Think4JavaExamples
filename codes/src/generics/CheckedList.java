package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Pet;

/**
 * @author wangzhichao
 * @since 2020/01/06
 */
public class CheckedList {

    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
        System.out.println(probablyDogs);
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<Dog>();
        // 向狗的集合里添加一只猫
        oldStyleMethod(dogs1);
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dogs2);
        } catch (Exception e) {
            System.out.println(e); // 抛出 ClassCastException，不再允许把猫放入狗集合里面。
        }
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
