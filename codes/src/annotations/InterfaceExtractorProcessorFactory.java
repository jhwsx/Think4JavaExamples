//package annotations;
//
//import com.sun.mirror.apt.AnnotationProcessor;
//import com.sun.mirror.apt.AnnotationProcessorEnvironment;
//import com.sun.mirror.apt.AnnotationProcessorFactory;
//import com.sun.mirror.declaration.AnnotationTypeDeclaration;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Set;
//
///**
// * 这是一个工厂类
// * <p>
// * 为 apt 工具指明正确的处理器，然后 apt 工具才能调用处理器上的
// * process() 方法
// *
// * @author wangzhichao
// * @since 2020/4/18
// */
//public class InterfaceExtractorProcessorFactory
//        implements AnnotationProcessorFactory {
//    @Override
//    public Collection<String> supportedOptions() {
//        return Collections.emptySet();
//    }
//
//    /**
//     * 返回支持的注解类型
//     * <p>
//     * 如果 String 集合里没有需要的注解的完整类名，apt 就找不到相应的
//     * 处理器，就会发出警告，然后什么也不做就退出。
//     *
//     * @return
//     */
//    @Override
//    public Collection<String> supportedAnnotationTypes() {
//        return Collections.singleton("annotations.ExtractInterface");
//    }
//
//    /**
//     * 返回注解处理器对象
//     *
//     * @param set 包含类型声明的 set（使用 apt 工具时传入的 Java 类）
//     * @param env AnnotationProcessorEnvironment 对象
//     * @return
//     */
//    @Override
//    public AnnotationProcessor getProcessorFor(
//            Set<AnnotationTypeDeclaration> set,
//            AnnotationProcessorEnvironment env) {
//        return new InterfaceExtractorProcessor(env);
//    }
//}
