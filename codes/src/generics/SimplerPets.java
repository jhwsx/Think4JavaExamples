package generics;

import net.mindview.util.New;

import java.util.List;
import java.util.Map;

import typeinfo.pets.Person;
import typeinfo.pets.Pet;

/**
 * @author wangzhichao
 * @since 2019/12/09
 */
public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();

    }
}
