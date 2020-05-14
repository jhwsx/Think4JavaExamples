//package annotations;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
///**
// * 这是一个自定义的注解，使用它可以把一个类中的 public 方法提取出来，
// * 构造成一个新的接口。
// *
// * @author wangzhichao
// * @since 2020/4/16
// */
//@Target(ElementType.TYPE)
//// 在源代码中可用，这是因为当我们从一个使用了该注解的类中抽取出接口后，没有必要
//// 再保留这些注解的信息。
//@Retention(RetentionPolicy.SOURCE)
//public @interface ExtractInterface {
//    public String value();
//}
