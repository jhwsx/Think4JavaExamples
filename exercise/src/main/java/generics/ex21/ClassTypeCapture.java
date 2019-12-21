package generics.ex21;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangzhichao
 * @since 2019/12/20
 */
class Building {}

class House extends Building {}

public class ClassTypeCapture<T> {
    Class<?> kind;
    Map<String, Class<?>> map;
    public ClassTypeCapture(Class<?> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture(Class<?> kind, Map<String, Class<?>> map) {
        this.kind = kind;
        this.map = map;
    }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typename, Class<?> kind) {
        map.put(typename, kind);
    }

    public Object createNew(String typename) throws InstantiationException, IllegalAccessException {
        if (map.containsKey(typename)) {
            return map.get(typename).newInstance();
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

        ClassTypeCapture<Building> ct = new ClassTypeCapture<>(Building.class, new HashMap<String, Class<?>>());
        ct.addType("House", House.class);
        ct.addType("Building", Building.class);
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
