package holding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CrossContainerIteration {
    public static void display(Iterator<Pet> it){
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() +":"+p+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petLinkedList = new LinkedList<>(pets);
        HashSet<Pet> petHashSet = new HashSet<>(pets);
        TreeSet<Pet> petTreeSet = new TreeSet<>(pets);
        display(pets.iterator());
        display(petLinkedList.iterator());
        display(petHashSet.iterator());
        display(petTreeSet.iterator());
    }
}
