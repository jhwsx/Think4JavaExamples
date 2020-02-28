//: typeinfo/pets/Pug.java
package typeinfo.ex15;

/**
 * 哈巴狗
 */
public class Pug extends Dog {
    public Pug(String name) {
        super(name);
    }

    public Pug() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<Pug> {
        @Override
        public Pug create() {
            return new Pug();
        }
    }
} ///:~
