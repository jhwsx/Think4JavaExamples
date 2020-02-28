//: typeinfo/pets/Dog.java
package typeinfo.ex15;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<Dog> {
        @Override
        public Dog create() {
            return new Dog();
        }
    }
} ///:~
