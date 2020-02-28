package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2019/12/29
 */
public class Wildcards {
    // Raw argument:
    // 对 Holder 表示成一个原生类型，就会放弃泛型的编译器检查。
    static void rawArgs(Holder holder, Object arg) {
        // 报出警告：Unchecked call to set(T) as a member of
        // raw type Holder
        holder.set(arg);
        holder.set(new Wildcards());

        // Error：T 哪里来的？
//        T t = holder.get();

        Object o = holder.get();
    }

    // UnboundedArg:
    // Holder<?> 和 Holder 是不同的：Holder<?> 表示 Holder 持有某种具体类型的同构集合
    // Holder 表示将持有任何类型的组合
    // 比 rawArgs 更严重，不再是警告，直接编译报错
    static void unboundedArg(Holder<?> holder, Object arg) {
        // 不可以调用 set 方法
//        holder.set(arg);

//        holder.set(new Wildcards());

//        T t = holder.get();

        Object o = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }
    // 协变 Producer Extends
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // 编译报错：
        // set(capture of ? extends T) in
        // Holder<capture of ? extends T>
        // cannot be applied to (T)
//         holder.set(arg);
        T t = holder.get();
        return t;
    }
    // 逆变 Consumer Super
    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        // Error:
        // Incompatible types: required T, found capture<? super T>
        // T t = holder.get();

        Object object = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        // or
        raw = new Holder();

        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, args);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exact1(raw);
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded);
        Long r4 = exact1(bounded);

        Long r5 = (Long) exact2(raw, lng);
        Long r6 = exact2(qualified, lng);
        // 编译报错：第二个参数错误，需要的是 ?, 给我 Long 干啥呢？
//          Long r7 = exact2(unbounded, lng);
        // 编译报错：第二个参数错误，需要的是 ? extends Long，给我 Long 干啥呢？
//         Long r8 = exact2(bounded, lng);

        // raw 只知道取出的是 Object 类型，你可以强转，但是会有类型转换异常的风险哦
        Long r9 = (Long) wildSubtype(raw, lng);
        // 这行是 ok 的, 需要的是 Holder<? extends Long>, 给我一个 Holder<Long> 是 ok 的。
        Long r10 = wildSubtype(qualified, lng);
        // 编译报错：第一个参数错误，需要的是 Holder<? extends Long>, 给我 Holder<?> 干啥呢？
//        Object r11 = wildSubtype(unbounded, lng);
        // 这行是 ok 的，需要的是 Holder<? extends Long>, 给我一个 Holder<? extends Long>, 完美啊。
        Long r12 = wildSubtype(bounded, lng);

        // 这行是 ok 的，需要的是 Holder<? super Long>, 给我一个 Holder 原生类型，好吧，我兼容你
        wildSupertype(raw, lng);
        // 这行是 ok 的，需要的是 Holder<? super Long>, 给我一个 Holder<Long>，是 ok 的。
        wildSupertype(qualified, lng);
        // 编译报错：需要的是 Holder<? super Long>, 给我一个 Holder<?>, 这不行
        // 我持有的是 Long 或者 Long 的基类型，? 可不对。
//        wildSupertype(unbounded, lng);
        // 编译报错：需要的是 Holder<? super Long>, 给我一个 Holder<? extends Long>, 这不行
        // 我持有的是 Long 或者 Long 的基类型，给我的是 Long 或者 Long 的子类型，这不行。
//        wildSupertype(bounded, lng);
    }


}
