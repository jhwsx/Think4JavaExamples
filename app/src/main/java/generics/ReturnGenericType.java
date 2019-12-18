package generics;

/**
 * @author wangzhichao
 * @since 2019/12/18
 */
public class ReturnGenericType<T extends HasF> {
    private T obj;

    public ReturnGenericType(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
