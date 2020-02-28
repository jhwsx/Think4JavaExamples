//: typeinfo/pets/Cat.java
package typeinfo.ex15;

import typeinfo.ex15.factory.Factory;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<Cat> {
        @Override
        public Cat create() {
            return new Cat();
        }
    }

} ///:~
