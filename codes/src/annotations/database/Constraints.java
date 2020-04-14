package annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于提取出数据库表的元数据
 *
 * @author wangzhichao
 * @since 2020/4/13
 */
@Target(ElementType.FIELD) // 注解可以用在域声明（包括 enum 实例）
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    boolean primaryKey() default false;

    boolean allowNull() default true;

    boolean unique() default false;
}
