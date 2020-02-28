package innerclasses;

/**
 * 内部类的继承
 * @author wzc
 * @date 2019/7/28
 */
class WithInner {
    class Inner {

    }
}
public class InheritInner extends WithInner.Inner{
//    InheritInner(){}
    InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
