package typeinfo.ex07;

/**
 * @author wangzhichao
 * @date 2019/11/02
 */
class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        if (args.length<1) {
            System.exit(1);
            return;
        }
        try {
            Class.forName("typeinfo.ex07."+args[0]);
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find "+args[0]);
        }
    }
}
