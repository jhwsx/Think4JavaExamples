package annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义 String 的 SQL 类型
 *
 * @author wangzhichao
 * @since 2020/4/13
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    int value() default 0;

    String name() default "";

    // 这里是嵌套注解的用法，注意默认值是 @Constraints。
    // 因为这个@Constraints的默认值后面没有括号指定元素的值，所以
    // 表示所有元素都为默认值的@Constraints注解。
    Constraints constraints() default @Constraints; // 注解也可以作为元素
}
