package arrays.ex10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzc
 * @date 2020/1/30
 */
public class Ex10<T> {
    List<T> array;

    public Ex10(int size) {
        array = new ArrayList<>(size);
    }

    public static void main(String[] args) {
        Ex10<String> ex10 = new Ex10<>(4);
//        ex10.array.add(5);
        ex10.array.add("hello");
    }
}
