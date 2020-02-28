package generics.ex42;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2020/01/15
 */
// 不同类型的函数对象

interface Combiner<T> {
    T combine(T x, T y);
}

interface UnaryFunction<R, T> {
    R function(T x);
}

interface Collector<T> extends UnaryFunction<T, T> {
    /**
     * 提取收集参数的结果
     */
    T result();
}

class Food {
    private String foodName = "";
    public Food() {
        foodName = "";
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public String get() {
        return foodName;
    }

    public void set(String foodName) {
        this.foodName = foodName;
    }

    public void eat() {
        foodName = "";
    }

    @Override
    public String toString() {
        return "Food: " + foodName;
    }
}

class Drink {
    private String drinkName = "";
    public Drink() {
        drinkName = "";
    }

    public Drink(String drinkName) {
        this.drinkName = drinkName;
    }

    public String get() {
        return drinkName;
    }

    public void set(String drinkName) {
        this.drinkName = drinkName;
    }

    public void eat() {
        drinkName = "";
    }

    @Override
    public String toString() {
        return "Drink: " + drinkName;
    }
}
public class Ex42 {
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if (it.hasNext()) {
            T result = it.next();
            while (it.hasNext()) {
                result = combiner.combine(result, it.next());
            }
            return result;
        }
        return null;
    }

    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq) {
            func.function(t);
        }
        return func;
    }

    static class MealMaker implements Combiner<Food> {

        @Override
        public Food combine(Food x, Food y) {
            return new Food(x.get() + " " + y.get());
        }
    }

    static class DrinkMaker implements Combiner<Drink> {
        @Override
        public Drink combine(Drink x, Drink y) {
            return new Drink(x.get() + " " + y.get());
        }
    }

    static class CookedMeal implements Collector<Food> {
        private Food f = new Food("");
        @Override
        public Food function(Food x) {
            f = new Food(f.get() + " " + x.get());
            return f;
        }

        @Override
        public Food result() {
            return new Food("cooked " + f.get());
        }
    }

    public static void main(String[] args) {
        List<Food> lf = Arrays.asList(new Food("bread"),
                new Food("ham"), new Food("cheese"));
        Food meal = reduce(lf, new MealMaker());
        System.out.println(meal);

        List<Drink> ld = Arrays.asList(new Drink("water"),
                new Drink("orange juice"), new Drink("lemon"));
        Drink drink = reduce(ld, new DrinkMaker());
        System.out.println(drink);
        System.out.println(forEach(lf, new CookedMeal()).result());
    }
}
