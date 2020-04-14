package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元素不能有不确定的值：要么有默认值，要么在使用注解时提供元素的值。
 * 对于非基本类型的元素，不管是在源代码中声明时，还是在注解接口中定义默认值时，都不能以 null 作为其值。
 *
 * @author wangzhichao
 * @since 2020/4/13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {
    public int id() default -1;

    public String description() default "";

    // public String name() default  null;

    public int age();
}
