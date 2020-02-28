package generics;

import java.util.HashMap;
import java.util.Map;

/**
 * 无界通配符表示任何类型
 * @author wangzhichao
 * @since 2019/12/29
 */
public class UnboundedWildcard2 {
    static Map map1;
    static Map<?,?> map2;
    static Map<String, ?> map3;
    static void assign1(Map map) {
        map1 = map;
    }

    static void assign2(Map<?, ?> map) {
        map2 = map;
    }

    static void assign3(Map<String, ?> map) {
        map3 = map;
    }

    public static void main(String[] args) {
        assign1(new HashMap());
        assign2(new HashMap<>());
        // 编译错误：需要的是Map<String,?>,给我一个HashMap<Object, Object> 干啥
        // assign3(new HashMap<>());
        assign1(new HashMap<String, Integer>());
        assign2(new HashMap<String, Integer>());
        assign3(new HashMap<String, Integer>());
    }
}
