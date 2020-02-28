package generics.ex24;

import java.util.HashMap;
import java.util.Map;

/**
 * Modify Exercise 21 so that factory objects are held in the Map instead of Class<?>.
 *
 * @author wangzhichao
 * @since 2019/12/21
 */
class Building {
}

class House extends Building {
}

interface Factory<T> {
    T create();
}

class BuildingFactory implements Factory<Building> {

    @Override
    public Building create() {
        return new Building();
    }
}

class HouseFactory implements Factory<House> {

    @Override
    public House create() {
        return new House();
    }
}

public class ClassTypeCapture<T> {
    Class<?> kind;
    Map<String, Factory<?>> map;

    public ClassTypeCapture(Class<?> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture(Class<?> kind, Map<String, Factory<?>> map) {
        this.kind = kind;
        this.map = map;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typename, Factory<?> kind) {
        map.put(typename, kind);
    }

    public Object createNew(String typename) throws InstantiationException, IllegalAccessException {
        if (map.containsKey(typename)) {
            return map.get(typename).create();
        }
        System.out.println(typename + " class not available");
        return null;
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 =
                new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 =
                new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));

        ClassTypeCapture<Building> ct = new ClassTypeCapture<>(Building.class, new HashMap<String, Factory<?>>());
        ct.addType("House", new HouseFactory());
        ct.addType("Building", new BuildingFactory());
        System.out.println("ct.map = " + ct.map);

        try {
            Building b = (Building) ct.createNew("Building");
            House h = (House) ct.createNew("House");
            System.out.println("b.getClass().getName() = " + b.getClass().getName());
            System.out.println("h.getClass().getName() = " + h.getClass().getName());
            System.out.println("h instanceof House = " + (h instanceof House));
            System.out.println("h instanceof Building = " + (h instanceof Building));
            System.out.println("b instanceof House = " + (b instanceof House));
            ct.createNew("String");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
