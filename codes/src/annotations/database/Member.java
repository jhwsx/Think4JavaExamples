package annotations.database;

/**
 * 在 Member 类上应用定义的注解
 *
 * @author wangzhichao
 * @since 2020/4/14
 */
@DBTable(name = "MEMBER") // MEMBER 将作为表的名字
public class Member {
    // 这里使用了快捷方式：如果程序员的注解中定义了名为value的元素，并且
    // 在应用注解的时候，如果该元素是唯一需要赋值的一个元素，那么此时无需
    // 使用名-值对的这种语法，而只需要在括号内给出 value 元素所需的值即可。
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30,
    constraints = @Constraints(primaryKey = true))
    String handle;
    static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return handle;
    }

    public Integer getAge() {
        return age;
    }
}
