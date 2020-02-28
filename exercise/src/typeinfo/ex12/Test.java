package typeinfo.ex12;

import net.mindview.util.TypeCounter;

/**
 * @author wangzhichao
 * @date 2019/11/30
 */
public class Test {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Coffee.class);
        for(Coffee coffee : new CoffeeGenerator(20)) {
            System.out.print(coffee.getClass().getSimpleName() + " ");
            counter.count(coffee);
        }
        System.out.println();
        System.out.println(counter);
    }
}
