package generics;

import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;


import typeinfo.pets.Person;
import typeinfo.pets.Pet;

import static net.mindview.util.Tuple.tuple;

/**
 * @author wangzhichao
 * @since 2019/12/15
 */
public class TupleTest2 {
    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static TwoTuple f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<Pet,String, Integer> g() {
        return tuple(new Pet(), "hi", 47);
    }

    static FourTuple<Person, Pet, String ,Integer> h() {
        return tuple(new Person("wzc"), new Pet(), "hi", 47);
    }

    static FiveTuple<Person, Pet, String, Integer, Double> k() {
        return tuple(new Person("wzc"), new Pet(), "hi", 47, 1.1D);
    }
    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
