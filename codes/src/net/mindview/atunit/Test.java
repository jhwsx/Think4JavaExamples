//: net/net.net.mindview/atunit/com.test.Test.java
// The @com.test.Test tag.
package net.mindview.atunit;
import java.lang.annotation.*;

@Target(ElementType.METHOD) // @Target 定义你的注解将应用于什么地方，是一个方法还是一个域
@Retention(RetentionPolicy.RUNTIME) // @Retention 用来定义该注解在哪一个级别可用，在源代码中（SOURCE）、在类文件中（CLASS）或者运行时（RUNTIME）
public @interface Test {} ///:~
