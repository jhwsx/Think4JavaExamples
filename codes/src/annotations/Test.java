package annotations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhichao
 * @since 2021/1/7
 */
public class Test {
    static final List<Integer> LIST = new ArrayList<>();

    public static void main(String[] args) {
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        LIST.add(1);

    }
}
