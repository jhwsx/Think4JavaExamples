package generics.ex14;

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

/**
 * @author wangzhichao
 * @since 2019/12/15
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
//        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}
