package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * List 表示持有任何 Object 类型的原生 List
 * List<?> 表示具有某种特定类型的非原生 List。
 * @author wangzhichao
 * @since 2019/12/29
 */
public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list){
        list1 = list;
        list2 = list;
        // 此行报出警告信息：未受检查的赋值，发现的是 List，
        // 但需要的是 List<? extends Object>
        list3 = list;
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList());
        // 报出警告：未检查的赋值，发现的是 ArrayList，
        // 需要的是 List<? extends Object>
        assign3(new ArrayList());

        assign1(new ArrayList<String>());
        assign2(new ArrayList<String>());
        assign3(new ArrayList<String>());

        List<?> wildList = new ArrayList();
        wildList = new ArrayList<String>();
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }
}
