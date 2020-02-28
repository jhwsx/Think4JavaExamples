package generics;

import net.mindview.util.FourTuple;

import java.util.ArrayList;

import typeinfo.Person;
import typeinfo.pets.Cat;
import typeinfo.pets.Pet;

/**
 * List 元组
 *
 * @author wangzhichao
 * @since 2019/12/18
 */
public class TupleList<A, B, C, D> extends ArrayList<FourTuple<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Person, Cat, String, Integer> tl = new TupleList<>();
        tl.add(TupleTest.h());
        tl.add(TupleTest.h());
        for (FourTuple<Person, Cat, String, Integer> tuple : tl) {
            System.out.println(tuple);
        }
    }
}
