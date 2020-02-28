package generics;

import net.mindview.util.New;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import typeinfo.pets.Person;
import typeinfo.pets.Pet;

/**
 * @author wangzhichao
 * @since 2019/12/09
 */
public class LimitsOfInference {
    static void f(Map<Person, List< ? extends Pet>> petPeople) {

    }

    public static void main(String[] args) {
        // 类型推断只对赋值操作有效，其他时候并不起作用。
        // f(New.map());
    }
}
