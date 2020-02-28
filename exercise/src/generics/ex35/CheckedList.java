package generics.ex35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import typeinfo.ex12.Coffee;
import typeinfo.ex12.Latte;
import typeinfo.ex12.Mocha;

/**
 * @author wangzhichao
 * @since 2020/01/06
 */
public class CheckedList {

    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyLattes) {
        probablyLattes.add(new Mocha());
        System.out.println(probablyLattes);
    }

    public static void main(String[] args) {
        List<Latte> latteList = new ArrayList<Latte>();
        oldStyleMethod(latteList);
        List<Latte> latteList2 = Collections.checkedList(new ArrayList<Latte>(), Latte.class);
        try {
            oldStyleMethod(latteList2);
        } catch (Exception e) {
            System.out.println(e); // 抛出 ClassCastException
        }
        List<Coffee> coffees = Collections.checkedList(new ArrayList<Coffee>(), Coffee.class);
        coffees.add(new Latte());
        coffees.add(new Coffee());
    }
}
