package typeinfo;

import net.mindview.util.Null;

/**
 * Person 类
 * <p>
 * 这是一个不可变类
 *
 * @author wangzhichao
 * @date 2019/12/01
 */
public class Person {
    public final String first;
    public final String last;
    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    /**
     * 懒汉式单例模式
     */
    public static class NullPerson extends Person implements Null {
        private NullPerson() {
            super("None", "None", "None");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }

    }

    public static final NullPerson NULL = new NullPerson();
}
