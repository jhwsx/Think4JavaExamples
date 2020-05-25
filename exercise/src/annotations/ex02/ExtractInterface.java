package annotations.ex02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangzhichao
 * @since 2020/5/11
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE) // 注意：这里用 SOURCE 就够了
public @interface ExtractInterface {
    String interfaceName() default "-!!-";
}
