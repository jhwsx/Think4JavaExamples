//: typeinfo/pets/Pet.java
package typeinfo.ex15;

public class Pet extends Individual {
    public Pet(String name) {
        super(name);
    }

    public Pet() {
        super();
    }

    public static class Factory implements typeinfo.ex15.factory.Factory<Pet> {
        @Override
        public Pet create() {
            return new Pet();
        }
    }
} ///:~
