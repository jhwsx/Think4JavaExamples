package generics;

/**
 * CRG（古怪的循环泛型）的本质：基类用导出类替代其参数
 * @author wangzhichao
 * @since 2020/01/05
 */
class Subtype extends BasicHolder<Subtype> {}

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype();
        Subtype st2 = new Subtype();
        // 导出类作为参数
        st1.set(st2);
        // 导出类作为返回类
        Subtype st3 = st1.get();
        // 导出类型用作其域类型
        st1.f(); // 打印：Subtype
    }
}
