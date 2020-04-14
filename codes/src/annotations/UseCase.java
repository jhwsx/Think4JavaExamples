package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangzhichao
 * @since 2020/4/13
 */
@Target(ElementType.METHOD) // 这个注解应用于方法
@Retention(RetentionPolicy.RUNTIME) // 这个注解在运行时可用, 因此可以通过反射机制读取注解的信息
public @interface UseCase {
    public int id();

    public String description() default "no description";
}
