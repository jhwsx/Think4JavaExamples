package innerclasses;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/07/21
 *     desc   : 使用匿名内部类在 interfaces/Factories.java 中
 *     version: 1.0
 * </pre>
 */
interface Service {
    void method1();

    void method2();
}

interface ServiceFactory {
    Service getService();
}

class Implementation1 implements Service {
    private Implementation1() {

    }
    @Override
    public void method1() {
        System.out.println("Implementation1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };
}

//class Implementation1Factory implements ServiceFactory {
//
//    @Override
//    public Service getService() {
//        return new Implementation1();
//    }
//}

class Implementation2 implements Service {
    private Implementation2() {

    }
    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}

//class Implementation2Factory implements ServiceFactory {
//
//    @Override
//    public Service getService() {
//        return new Implementation2();
//    }
//}

class Implementation3 implements Service {
    private Implementation3() { // 可以私有化了

    }
    @Override
    public void method1() {
        System.out.println("Implementation3 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation3 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation3();
        }
    };
}

//class Implementation3Factory implements ServiceFactory {
//
//    @Override
//    public Service getService() {
//        return new Implementation3();
//    }
//}

public class Factories {
    public static void serviceConsumer(ServiceFactory fact) {
        Service service = fact.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
//        serviceConsumer(new Implementation1Factory());
//        serviceConsumer(new Implementation2Factory());
//        serviceConsumer(new Implementation3Factory());

        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
        serviceConsumer(Implementation3.factory);
    }
}
