package generics;

import net.mindview.util.New;

import java.util.List;
import java.util.Map;

import typeinfo.pets.Person;
import typeinfo.pets.Pet;

/**
 * 显示的类型说明
 *
 * @author wangzhichao
 * @since 2019/12/15
 */
public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {

    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
}
