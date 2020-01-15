package generics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 使用策略设计模式
 * <p>
 * 将“变化的事物”完全隔离到一个函数对象中。函数对象就是在某种程度上行为像函数的对象
 *
 * @author wangzhichao
 * @since 2020/01/13
 */
// 不同类型的函数对象

/**
 * 将两个值以某种方式运算，得出另一个值
 *
 * @param <T>
 */
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

interface UnaryPredicate<T> {
    boolean test(T x);
}

public class Functional {
    // Calls the Combiner object on each element to combine
    // it with a running result, which is finally returned
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

    // Take a function object and call it on each object in
    // the list, ignoring the return value. The function
    // object may act as a collecting parameter, so it is
    // returned at the end.
    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq) {
            func.function(t);
        }
        // 调用 getResult() 方法可以返回结果。
        return func;
    }

    // Creates a list of results by calling a
    // function object for each object in the list
    public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> func) {
        List<R> result = new ArrayList<>();
        for (T t : seq) {
            result.add(func.function(t));
        }
        return result;
    }

    // Applies a unary predicate to each item in a sequence,
    // and returns a list of items that produced "true"
    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<>();
        for (T t : seq) {
            if (pred.test(t)) {
                result.add(t);
            }
        }
        return result;
    }


    // To use the above generic methods, we need to create
    // function objects to adapt to our particular needs:
    // 下面是函数对象的具体实现
    // 整数相加器
    static class IntegerAdder implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    // 整数相减器
    static class IntegerSubtracter implements Combiner<Integer> {
        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    // BigDecimal 相加器
    static class BigDecimalAdder implements Combiner<BigDecimal> {
        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    // 大整数 相加器
    static class BigIntegerAdder implements Combiner<BigInteger> {

        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    // 原子 Long 型相加器
    static class AtomicLongAdder implements Combiner<AtomicLong> {

        @Override
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal> {
        @Override
        public BigDecimal function(BigDecimal x) {
            // the unit in the last place (ULP)
            return x.ulp();
        }
    }

    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private T bound;

        GreaterThan(T bound) {
            this.bound = bound;
        }

        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector implements Collector<Integer> {
        private Integer val = 1;

        @Override
        public Integer function(Integer x) {
            val *= x;
            return val;
        }

        @Override
        public Integer result() {
            return val;
        }
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        // 把集合 li 中的元素依次相加 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
        Integer result = reduce(li, new IntegerAdder());
        System.out.println(result);
        // 把集合 li 中的元素依次相减 1 - 2 - 3 - 4 - 5 - 6 - 7 = -26
        result = reduce(li, new IntegerSubtracter());
        System.out.println(result); // 打印：-26

        // 过滤出集合 li 中比 4 大的元素：5， 6， 7
        System.out.println(filter(li, new GreaterThan<Integer>(4))); // 打印：[5, 6, 7]

        // 对集合 li 中的元素依次相乘，得出结果：1 * 2 * 3 * 4 * 5 * 6 * 7 = 5040
        System.out.println(forEach(li, new MultiplyingIntegerCollector()).result());
        // 过滤出集合 li 中比 4 大的元素放在一个集合，再把新集合里的元素连乘: 5 * 6 * 7 = 210
        System.out.println(forEach(filter(li, new GreaterThan<Integer>(4)), new MultiplyingIntegerCollector()).result());

        MathContext mc = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(
                new BigDecimal(1.1, mc), new BigDecimal(2.2, mc),
                new BigDecimal(3.3, mc), new BigDecimal(4.4, mc)
        );
        // 对集合 lbd 里的元素依次相加，精度是 7.
        BigDecimal rbd = reduce(lbd, new BigDecimalAdder());
        System.out.println(rbd);

        // 过滤出集合 lbd 里的 大于 3 的元素，精度是 7
        System.out.println(filter(lbd, new GreaterThan<BigDecimal>(new BigDecimal(3))));

        List<BigInteger> lbi = new ArrayList<>();
        BigInteger bi = BigInteger.valueOf(11);
        for (int i = 0; i < 11; i++) {
            lbi.add(bi);
            // 返回一个整数大于该BigInteger的素数
            // 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数。
            bi = bi.nextProbablePrime();
        }
        System.out.println(lbi); // [11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]

        // 把集合 lbi 里的元素依次相加 11 + 13 + 17 + 19 + 23 + 29 + 31 + 37 +  41 + 43 + 47 = 311
        BigInteger rbi = reduce(lbi, new BigIntegerAdder());
        System.out.println(rbi); // 打印：311

        // 判断 5 是不是素数
        System.out.println(rbi.isProbablePrime(5));

        List<AtomicLong> lal = Arrays.asList(
                new AtomicLong(11), new AtomicLong(47),
                new AtomicLong(74), new AtomicLong(133)
        );
        // 对集合 lal 里的元素依次相加：11 + 47 + 74 + 133 = 265
        AtomicLong ral = reduce(lal, new AtomicLongAdder());
        System.out.println(ral); // 265
        System.out.println(transform(lbd, new BigDecimalUlp()));
    }

}






























