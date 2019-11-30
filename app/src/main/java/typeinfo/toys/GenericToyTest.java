package typeinfo.toys;

/**
 * @author wangzhichao
 * @date 2019/11/30
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        // 产生准确的类型
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        // 下面这行不可以编译通过
//        Class<Toy> up2 = ftClass.getSuperclass();
        Object obj = up.newInstance();
        Class<? extends Toy> toy = FancyToy.class;
        Toy toy1 = toy.newInstance();
    }
}

/**
 * 总结:
 * 1, 当泛型语法用于 Class 对象时, newInstance() 方法将会返回一个确切类型, 而非 Object;
 * 2, 但是使用 ? super 填充时, 仍然会返回 Object.
 * 3, 当使用 ? extends BoundedType 填充时，会返回 BoundedType 类型。
 * 4，这里其实还是通过多态的概念来理解就好了。
 */