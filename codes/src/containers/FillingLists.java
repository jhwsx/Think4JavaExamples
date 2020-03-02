package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangzhichao
 * @since 20-2-28
 */
class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
public class FillingLists {
    public static void main(String[] args) {
        // 这个方法返回的是一个不可变的集合,这是因为返回的是 CopiesList，它没有实现修改的方法
        List<StringAddress> helloList = Collections.nCopies(4, new StringAddress("Hello"));
        // helloList.add(new StringAddress("Hello"));
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("Hello"))
        );
        System.out.println(list);
        System.out.println("----------------------------------");
        // 替换集合中所有的元素,而不是填充
        Collections.fill(list, new StringAddress("World"));
        System.out.println(list);
    }
}
