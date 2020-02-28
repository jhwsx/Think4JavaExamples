//: typeinfo/pets/ForNameCreator.java
package typeinfo.ex11.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<Class<? extends Pet>>();
    // Types that you want to be randomly created:
    private static String[] typeNames = {
            "typeinfo.ex11.pets.Mutt",
            "typeinfo.ex11.pets.Pug",
            "typeinfo.ex11.pets.EgyptianMau",
            "typeinfo.ex11.pets.Manx",
            "typeinfo.ex11.pets.Cymric",
            "typeinfo.ex11.pets.Rat",
            "typeinfo.ex11.pets.Mouse",
            "typeinfo.ex11.pets.Hamster",
            "typeinfo.ex11.pets.Gerbil"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames)
                types.add(
                        (Class<? extends Pet>) Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    public List<Class<? extends Pet>> types() {
        return types;
    }
} ///:~
