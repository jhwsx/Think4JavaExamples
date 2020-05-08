package annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code @DBTable} 有一个 name 元素，该注解通过这个元素为处理器创建数据库表提供表的名字。
 *
 * @author wangzhichao
 * @since 2020/4/13
 */
@Target(ElementType.TYPE) // 应用于类，接口（包括注解类型）以及 枚举声明
@Retention(RetentionPolicy.RUNTIME) // 在运行时可用
public @interface DBTable {
    // name 元素
    public String name() default "";
}
