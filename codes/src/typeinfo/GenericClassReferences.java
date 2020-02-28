package typeinfo;

/**
 * 泛化的Class引用
 *
 * @author wangzhichao
 * @date 2019/11/28
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        // 等价于
        genericIntClass = Integer.class;
        intClass = double.class;
        // genericIntClass = Double.class; // 编译报错:类型不匹配
        // Class<Number> genericNumberClass = double.class; // 编译报错: 类型不匹配
    }
}
