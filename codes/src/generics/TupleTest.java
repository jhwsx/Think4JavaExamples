package generics;

import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

import typeinfo.Person;
import typeinfo.pets.Cat;


/**
 * @author wangzhichao
 * @since 2019/12/08
 */
public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<Cat,String, Integer> g() {
        return new ThreeTuple<>(new Cat(), "hi",47);
    }

    static FourTuple<Person, Cat, String, Integer> h() {
        return new FourTuple<>(new Person("a", "b", "c"), new Cat(), "hi", 47);
    }

    static FiveTuple<Boolean, Person, Cat, String, Integer> k() {
        return new FiveTuple<>(false, new Person("a", "", ""), new Cat(), "hi", 47);
    }
    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
//        ttsi.first = "there";
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());

    }
}
