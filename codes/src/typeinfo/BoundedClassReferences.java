package typeinfo;

/**
 * 带范围的 Class 引用
 *
 * @author wangzhichao
 * @date 2019/11/28
 */
public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
