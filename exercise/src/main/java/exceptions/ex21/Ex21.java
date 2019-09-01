package exceptions.ex21;

class BaseClass {
    public BaseClass() throws Exception {

    }
}

class DerivedClass extends BaseClass {

    public DerivedClass() throws Exception {
        // this() 必须是第一行，所以派生类的构造器不能捕获基类构造器所抛出的异常
//        try {
//            this();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
public class Ex21 {
}
