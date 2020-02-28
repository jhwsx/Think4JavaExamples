package generics;

/**
 * 一个类不能实现同一个泛型接口的两种变体。
 *
 * @author wangzhichao
 * @since 2020/01/04
 */
public class MultipleInterfaceVariants {
    interface Payable<T> {
    }

    class Employee implements Payable<Employee> {

    }
    // Hourly 不能编译，因为擦除会将 Payable<Employee> 和 Payable<Hourly>
    // 简化为相同的类 Payable。
    /*
    generics\MultipleInterfaceVariants.java:16: 错误: 无法使用以下不同的参数继承Paya
ble: <generics.MultipleInterfaceVariants.Hourly> 和 <generics.MultipleInterfaceV
ariants.Employee>
    class Hourly extends Employee implements Payable<Hourly> {
    ^
1 个错误
    */
//    class Hourly extends Employee implements Payable<Hourly> {
//
//    }

    // 这样也不行
//    class Hourly extends Employee implements Payable {
//
//    }

    class Em implements Payable {

    }
    // 这样却是可以的
    class Hourly extends Em implements Payable {

    }

    public static void main(String[] args) {

    }
}


