package generics;

/**
 * Erased.java 中使用 new 对象的方式创建泛型类型对象是不行的
 *
 * 创建类型实例
 * 这里使用工厂方法，并使用了类型标签
 *
 * @author wangzhichao
 * @since 2019/12/20
 */
class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe =
                new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");

        try {
            // Integer 类没有默认构造器，导致 newInstance 方法失败
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}
