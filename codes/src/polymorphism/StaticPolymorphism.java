package polymorphism;

/**
 * @author wzc
 * @date 2019/7/13
 */
class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }

    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}
public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper staticSuper = new StaticSub();
        System.out.println(staticSuper.staticGet());
        System.out.println(staticSuper.dynamicGet());
    }
}
