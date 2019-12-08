package generics.ex08;

import androidx.annotation.NonNull;

import net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @author wangzhichao
 * @since 2019/12/08
 */
public class StoryCharactersGenerator implements Generator<StoryCharacters>, Iterable<StoryCharacters> {

    private Class[] types = {
            BatMan.class, SpiderMan.class, SuperMan.class,
            Vampire.class, Venom.class
    };
    private static Random random = new Random(47);

    public StoryCharactersGenerator() {
    }

    public StoryCharactersGenerator(int size) {
        this.size = size;
    }

    // For iteration
    private int size = 0;
    @NonNull
    @Override
    public Iterator<StoryCharacters> iterator() {
        return new StoryCharactersIterator();
    }

    @Override
    public StoryCharacters next() {
        try {
            return (StoryCharacters) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    class StoryCharactersIterator implements Iterator<StoryCharacters> {
        int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public StoryCharacters next() {
            count--;
            return StoryCharactersGenerator.this.next();
        }
    }

    public static void main(String[] args) {
        StoryCharactersGenerator generator = new StoryCharactersGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
        System.out.println();
        System.out.println();

        for (StoryCharacters storyCharacters : new StoryCharactersGenerator(5)) {
            System.out.println(storyCharacters);
        }
    }

}
