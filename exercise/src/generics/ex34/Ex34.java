package generics.ex34;

import java.util.Collections;

/**
 * @author wangzhichao
 * @since 2020/01/06
 */
abstract class MyClass<T extends MyClass<T>> {
    abstract T f(T t);

    T g(T t) {
        return f(t);
    }
}

class MyClassImpl extends MyClass<MyClassImpl> {

    @Override
    MyClassImpl f(MyClassImpl myClass) {
        return myClass;
    }
}
public class Ex34 {
    public static void main(String[] args) {
        MyClassImpl myClass = new MyClassImpl();
        MyClassImpl g = myClass.g(myClass);
    }
}
