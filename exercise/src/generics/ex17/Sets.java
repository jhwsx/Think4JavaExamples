package generics.ex17;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wangzhichao
 * @since 2019/12/16
 */
public class Sets {
    /**
     * 并集
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        try {
            if (a instanceof EnumSet) {
                Set<T> result = ((EnumSet) a).clone();
                result.addAll(b);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    /**
     * 交集
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T>
    Set<T> intersection(Set<T> a, Set<T> b) {
        try {
            if (a instanceof EnumSet) {
                Set<T> result = ((EnumSet) a).clone();
                result.retainAll(b);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * 差集
     * @param superset
     * @param subset
     * @param <T>
     * @return
     */
    // Subtract subset from superset:
    public static <T> Set<T>
    difference(Set<T> superset, Set<T> subset) {
        try {
            if (superset instanceof EnumSet) {
                Set<T> result = ((EnumSet) superset).clone();
                result.removeAll(subset);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(subset);
        return result;
    }

    /**
     * 补集
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    // Reflexive--everything not in the intersection:
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

} ///:~

