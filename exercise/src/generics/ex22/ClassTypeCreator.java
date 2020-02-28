package generics.ex22;


import java.lang.reflect.InvocationTargetException;

/**
 * @author wangzhichao
 * @since 2019/12/20
 */
class Building {
}

class House extends Building {
    private String location;
    private Integer area;

    public House() {
        location = null;
    }

    public House(Integer area) {
        this.area = area;
    }

    public House(String location) {
        this.location = location;
    }

    public House(String location, Integer area) {
        this.location = location;
        this.area = area;
    }

    @Override
    public String toString() {
        return "House" + ((location == null) ? "" : " in " + location) +
                (area != null ? (", " + area + " sqft") : "");
    }
}

public class ClassTypeCreator<T> {
    Class<?> kind;

    public ClassTypeCreator(Class<?> kind) {
        this.kind = kind;
    }

    public Object createNew(String typename) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return Class.forName(typename).newInstance();
    }

    public Object createNew(String typename, Object... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        switch (args.length) {
            case 1:
                return Class.forName(typename).getConstructor(args[0].getClass()).newInstance(args[0]);
            case 2:
                return Class.forName(typename).getConstructor(args[0].getClass(), args[1].getClass())
                        .newInstance(args[0], args[1]);
            default:
                return null;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ClassTypeCreator<Building> ctcb = new ClassTypeCreator<>(Building.class);
        ClassTypeCreator<Object> ctch = new ClassTypeCreator<>(House.class);
        House h = (House) ctch.createNew("generics.ex22.House", "Hawaii");
        System.out.println(h);
        House h2 = (House) ctch.createNew("generics.ex22.House", 3000);
        System.out.println(h2);
        House h3 = (House) ctch.createNew("generics.ex22.House", "Manila", 5000);
        System.out.println(h3);
    }
}
