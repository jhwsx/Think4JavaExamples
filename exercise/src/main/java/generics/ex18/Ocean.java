package generics.ex18;

import androidx.annotation.NonNull;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import generics.ex13.Generators;

/**
 * @author wangzhichao
 * @since 2019/12/17
 */
class BigFish {
    private static long counter = 1;
    private final long id = counter++;

    private BigFish() {
        //no instance
    }

    @Override
    public String toString() {
        return "BigFish " + id;
    }

    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}

class LittleFish {
    private static long counter = 1;
    private final long id = counter++;

    private LittleFish() {
        //no instance
    }

    @Override
    public String toString() {
        return "LittleFish " + id;
    }

    public static Generator<LittleFish> generator = new Generator<LittleFish>() {
        @Override
        public LittleFish next() {
            return new LittleFish();
        }
    };
}

public class Ocean {
    static void eat(BigFish bigFish, LittleFish littleFish) {
        System.out.println(bigFish + " eat " + littleFish);
    }
    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<LittleFish> littleFish = new LinkedList<>();
        Generators.fill(littleFish, LittleFish.generator, 15);
        List<BigFish> bigFishList = new ArrayList<>();
        Generators.fill(bigFishList, BigFish.generator(), 4);
        for (LittleFish lf : littleFish) {
            eat(bigFishList.get(random.nextInt(bigFishList.size())), lf);
        }
    }
}
