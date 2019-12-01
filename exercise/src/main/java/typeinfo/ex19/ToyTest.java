package typeinfo.ex19;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLOutput;

/**
 * @author wangzhichao
 * @date 2019/11/02
 */
interface HasBatteries {

}

interface Waterproof {

}

interface Shoots {

}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());

    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("typeinfo.ex19.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj =  up.newInstance();
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        }
        printInfo(obj.getClass());
        try {
            Constructor<Toy> toyConstructor = Toy.class.getDeclaredConstructor(int.class);
            toyConstructor.setAccessible(true);
            Toy toy = toyConstructor.newInstance(5);
            System.out.println("toy = " + toy);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 总结：
 * 1，通过拿到了 Class 对象，可以发现所要了解的类型的所有信息。
 */
