package holding;


import java.util.List;
import java.util.ListIterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        for (Pet pet : pets) {
            System.out.print(pet + ",index=" + pets.indexOf(pet) +"; ");
        }
        System.out.println();
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        System.out.println();
        while (it.hasPrevious()) {
            System.out.print(it.previous().id() + " ");
        }
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(3);
        while (it.hasNext()) {
            Pet next = it.next();
            System.out.print(next + ", ");
            it.set(Pets.randomPet());
        }
        System.out.println();
        System.out.println(pets);
    }
}
