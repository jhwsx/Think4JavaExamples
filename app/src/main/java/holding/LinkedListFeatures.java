package holding;

import java.util.LinkedList;

import typeinfo.pets.Hamster;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
import typeinfo.pets.Rat;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(5));
        System.out.println(pets);
        // 一致的
        System.out.println("pets.getFirst(): " + pets.getFirst());
        System.out.println("pets.element(): " +pets.element());
        // 当集合为空时返回 null
        System.out.println("pets.peek(): "+pets.peek());
        // 移除
        System.out.println("pets.remove(): " + pets.remove());
        System.out.println("pets.removeFirst(): " + pets.removeFirst());
        // 当集合为空时 返回 null
        System.out.println("pets.poll(): "+pets.poll());
        System.out.println(pets);
        pets.addFirst(new Rat());
        System.out.println("After addFirst(): " + pets);
        pets.offer(Pets.randomPet());
        System.out.println("After offer(): " + pets);
        pets.add(Pets.randomPet());
        System.out.println("After add(): " + pets);
        pets.addLast(new Hamster());
        System.out.println("After addLast(): " + pets);
    }
}
