package containers;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.mindview.util.Generator;
import net.mindview.util.MapData;
import net.mindview.util.Pair;
import net.mindview.util.RandomGenerator;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wangzhichao
 * @since 2020/2/28
 */
class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, (letter++) + " ");
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

}
public class MapDataTest {
    public static void main(String[] args) {
        // A single Pair Generator:
        System.out.println(new MapData<>(new Letters(), 11));
        // Two separate Generators:
        System.out.println(new MapData<String, Integer>(new RandomGenerator.String(8),
                new RandomGenerator.Integer(), 8));
        // A key Generator and a single value:
        System.out.println(new MapData<>(new RandomGenerator.Integer(), "value",
                8));
        // An Iterable and a value Generator:
        System.out.println(new MapData<>(new Letters(), new RandomGenerator.Integer()));
        // An Iterable and a single value:
        System.out.println(new MapData<>(new Letters(), "value"));

        System.out.println("------------------");

        System.out.println(MapData.map(new Letters(), 11));
        System.out.println(MapData.map(new RandomGenerator.String(8),
                new RandomGenerator.Integer(), 8));
        System.out.println(MapData.map(new RandomGenerator.Integer(), "value", 8));
        System.out.println(MapData.map(new Letters(), new RandomGenerator.Integer()));
        System.out.println(MapData.map(new Letters(), "value"));

        // 这样写是错误的
//        Map<Integer, String> map = new LinkedHashMap<>();
//        MapData<Integer, String> map1 = MapData.map(new Letters(), 11);
//        for (Map.Entry<Integer, String> integerStringEntry : map1.entrySet()) {
//            Collections.addAll(map, integerStringEntry);
//        }

    }
}
