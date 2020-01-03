package generics.ex29;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

/**
 * @author wangzhichao
 * @since 2020/01/03
 */
/* Create a generic method that takes as an argument a Holder<List<?>>.
 * Determine what methods you can and can't call for the Holder and for
 * the List. Repeat for an argument of List<Holder<?>>.
 */
public class Ex29 {
    static void f1(Holder<List<?>> holder) {
        System.out.println("Calling methods for the Holder:");
        System.out.println("holder = " + holder);
        System.out.println("holder.get() = " + holder.get());
        System.out.println("Calling holder.set(Arrays.asList(1,2,3))");
        holder.set(Arrays.asList(1,2,3));
        System.out.println("holder.get() = " + holder.get());
        int[] ia = {1, 2, 3};
        System.out.println("int[] ia = {1, 2, 3}");
        System.out.println("holder.equals(ia) = " + holder.equals(ia));
        List iaList = Arrays.asList(ia);
        System.out.println("List iaList = Arrays.asList(ia)");
        System.out.println("holder.equals(iaList) = " + holder.equals(iaList));
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            l.add(i);
        }
        System.out.println("l = List<Integer>() and add 1,2,3");
        System.out.println("holder.equals(l) = " + holder.equals(l));
        System.out.println();

        System.out.println("Calling methods for the List:");
        System.out.println("holder.get() = " + holder.get());
        System.out.println("holder.get().getClass() = " + holder.get().getClass());
        // 编译错误：类型不兼容，需要的是 List<? extends Integer>, 给我一个 List<?> 干啥
//        List<? extends Integer> list = holder.get();
        List<?> list = holder.get();
        System.out.println("list = " + list);
        // 编译出错：不可以添加数据
//        list.add(new Object());
        List list1 = holder.get();
        // 此行报警告：因为我们没有给定泛型，希望我们用泛型在这里
        // 但是，这行运行时报错：因为这是 Arrays$ArrayList，底层是数组，不支持修改。
//        list1.add(new Object());
        System.out.println("list1.getClass() = " + list1.getClass());
        System.out.println("list.equals(list1) = " + list.equals(list1));
        // 这行运行时报错，不支持的操作异常
//        list.clear();
        System.out.println("list.contains(l) = " + list.contains(l));
        Collection<Integer> c = new HashSet<>();
        for (int i = 1; i < 4; i++) {
            c.add(i);
        }
        System.out.println("list.containsAll(c) = " + list.containsAll(c)); // true
        System.out.println("list.equals(c) = " + list.equals(c)); // false, 类型都不一样
        System.out.println("list = " + list);
        System.out.println("c = " + c);
        System.out.println("c.getClass() = " + c.getClass());
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.hashCode() = " + list.hashCode());
        System.out.println("list.indexOf(2) = " + list.indexOf(2));
        ListIterator<?> li = list.listIterator();
        System.out.println("After ListIterator li = list.listIterator():");
        System.out.println("li.next() = " + li.next());
        // 运行时报错：不支持的操作
//        list.remove(0);
//        list.removeAll(c);
        list.retainAll(c);
        // 编译报错：需要的是 ?,给我一个 int 干啥呢？
//        list.set(1, 4);
        System.out.println("list.size() = " + list.size());
        System.out.println("list.subList(1,2) = " + list.subList(1, 2)); // [2]
        Object[] oa = list.toArray();
        System.out.println("After Object[] oa = list.toArray():");
        System.out.println("oa = ");
        for (Object o : oa) {
            System.out.print(o + " ");
        }
        System.out.println();
        // 此行运行报错：Exception in thread "main" java.lang.ArrayStoreException
//        Double[] da = list.toArray(new Double[3]);
        Number[] na = list.toArray(new Number[3]);
        System.out.println("After  Number[] na = list.toArray(new Number[3]):");
        System.out.println("na = ");
        for (Number n : na) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    static void f2(List<Holder<?>> list) {
        System.out.println("Calling methods for the List:");
        System.out.println("list = " + list);
        System.out.println("Adding Integer, String, Double");
        list.add(new Holder<Integer>(1));
        list.add(new Holder<String>("two"));
        list.add(new Holder<Double>(3.0));
        System.out.println("list = " + list);
        System.out.println("Elements of list:");
        for (Holder<?> holder : list) {
            System.out.println("holder.get() = " + holder.get());
        }
        System.out.println("Adding Float");
        list.add(3, new Holder<Float>(4.0f));
        System.out.println("list = " + list);
        System.out.println("Elements of list:");
        for (Holder<?> holder : list) {
            System.out.println("holder.get() = " + holder.get());
        }
        System.out.println("list.clear()");
        list.clear();
        System.out.println("list = " + list);
        Collection<Holder<?>> c = new ArrayList<Holder<?>>();
        c.add(new Holder<String>("one"));
        c.add(new Holder<Float>(2.0f));
        c.add(new Holder<Double>(3.0));
        list.addAll(c);
        System.out.println("Adding String, Float, Double");
        System.out.println("list = " + list);
        System.out.println("Elements of list:");
        for (Holder<?> h : list) {
            System.out.println("h.get() = " + h.get().getClass().getSimpleName()
            + " " + h.get());
        }
        list.add(3, new Holder<String>("four"));
        System.out.println("Elements of list:");
        for (Holder<?> h : list) {
            System.out.println("h.get() = " + h.get().getClass().getSimpleName()
                    + " " + h.get());
        }
        Object listClone = ((ArrayList) list).clone();
        System.out.println("((ArrayList) list).clone() = " + listClone);
        System.out.println("((ArrayList) list).clone().getClass() = " + ((ArrayList) list).clone().getClass());
        // 编译报错：需要一个 ArrayList，给我一个 Object 干啥
        // ArrayList alistClone = ((ArrayList) list).clone();
        System.out.println("Replacing element with h4, new Holder<Integer>(4)");
        Holder<Integer> h4 = new Holder<>(4);
        list.set(3, h4);
        System.out.println("Elements of list:");
        for (Holder<?> h : list) {
            System.out.println("h.get() = " + h.get().getClass().getSimpleName()
                    + " " + h.get());
        }
        System.out.println("list.contains(list.set(3, h4)) = " + list.contains(list.set(3, h4))); // 返回的是之前的元素
        System.out.println("list.contains(4) = " + list.contains(4));
        // todo 这里怎么返回 false？
        System.out.println("list.contains(h4) = " + list.contains(h4));
        System.out.println("Adding null member to list");
        list.add(null);
        System.out.println("list.contains(null) = " + list.contains(null));
        System.out.println("list.get(0).get() = " + list.get(0).get());
        System.out.println("list.indexOf(h4) = " + list.indexOf(h4)); // -1
        System.out.println("list.indexOf(null) = " + list.indexOf(null));
        System.out.println("list.isEmpty() = " + list.isEmpty());
        System.out.println("list.lastIndexOf(null) = " + list.lastIndexOf(null));
        System.out.println("Rmoving index 0");
        list.remove(0);
        System.out.println("Elements of list Holders:");
        for (Holder<?> h : list) {
            if (h == null) {
                System.out.println("null");
            } else {
                System.out.println(h.get().getClass().getSimpleName() + " " + h.get());
            }
        }
        System.out.println("Removing null");
        list.remove(null);
        System.out.println("Elements of list Holders:");
        for (Holder<?> h : list) {
            if (h == null) {
                System.out.println("null");
            } else {
                System.out.println(h.get().getClass().getSimpleName() + " " + h.get());
            }
        }
        System.out.println("list.size() = " + list.size());
        Object[] oa = list.toArray();
        System.out.println("list.toArray() = ");
        for (int i = 0; i < oa.length; i++) {
            System.out.print(oa[i] + " ");
        }
        System.out.println();
        Holder[] ha = ((ArrayList<Holder<?>>) list).toArray(new Holder[4]);
        System.out.println("((ArrayList<Holder<?>>) list).toArray(new Holder[4]) = ");
        for (int i = 0; i < ha.length; i++) {
            System.out.print(ha[i] + " ");
        }
        System.out.println();
        System.out.println("Holder[] holders are holding:");
        for (Holder h : ha) {
            if (h == null) {
                System.out.println("null");
            } else {
                System.out.println(h.get());
            }
        }
        System.out.println();

        System.out.println("Calling methods for the Holder:");
        System.out.println("list = " + list);
        System.out.println("Three Holders(one null) in list");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                System.out.println("null");
            } else {
                System.out.println(list.get(i).getClass().getSimpleName());
            }
        }
//        list.remove(3);
        System.out.println("Holders are holding:");
        for (Holder<?> holder : list) {
            System.out.println(holder.get());
        }
        Holder<?> h1 = list.get(0);
        Holder<?> h2 = list.get(1);
//        Holder<?> h3 = list.get(2);
        System.out.println(list.get(0).getClass() + ": "
                + list.get(0).get().getClass().getSimpleName() + ", "
                + list.get(0).get());
        System.out.println(list.get(1).getClass() + ": "
                + list.get(1).get().getClass().getSimpleName() + ", "
                + list.get(1).get());
//        System.out.println(list.get(2).getClass() + ": "
//                + list.get(2).get().getClass().getSimpleName() + ", "
//                + list.get(2).get());
        // 编译报错
//        h2.set(5);
    }

    public static void main(String[] args) {
        System.out.println("new Holder<List<?>> holder");
        f1(new Holder<List<?>>());
        System.out.println();
        System.out.println("List<Holder<?>> list = new ArrayList<Holder<?>>():");
        List<Holder<?>> list = new ArrayList<Holder<?>>();
        f2(list);
    }
}
