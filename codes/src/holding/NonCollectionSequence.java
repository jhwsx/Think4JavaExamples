package holding;

import java.util.Iterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * <pre>
 *     author : wangzhichao
 *     e-mail : wangzhichao@adups.com
 *     time   : 2019/08/18
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}
public class NonCollectionSequence extends PetSequence {
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nonCollectionSequence = new NonCollectionSequence();
        InterfaceVsIterator.display(nonCollectionSequence.iterator());
    }
}
