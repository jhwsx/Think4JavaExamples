package typeinfo;

/**
 * 带通配符的Class引用
 *
 * @author wangzhichao
 * @date 2019/11/28
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
