package typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * FilledList 存储了一个类引用, 并产生一个 List
 *
 * @author wangzhichao
 * @date 2019/11/28
 */
class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < nElements; i++) {
            try {
                result.add(type.newInstance());
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl =
                new FilledList<>(CountedInteger.class);
        System.out.println(fl.create(15));
        Class<CountedInteger> clazz = CountedInteger.class;
    }
}
