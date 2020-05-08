package annotations.simplest;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * 这是一个简单的处理器，作用是把注解相关的信息打印出来。
 *
 * @author wangzhichao
 * @since 2020/5/8
 */
@SupportedAnnotationTypes("annotations.simplest.Simple")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SimpleProcessor extends AbstractProcessor {
    /**
     * 处理方法
     * @param annotations 可以知道哪个注解是存在的
     * @param roundEnv 保留了剩余信息
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // 打印注解
        for (TypeElement t : annotations) {
            System.out.println(t);
        }
        // 获取所有被 @Simple 注解的元素
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(Simple.class);
        for (Element element : elementsAnnotatedWith) {
            display(element);
        }
        return false;
    }

    /**
     * 展示每一个元素的基本信息
     *
     * @param element
     */
    private void display(Element element) {
        System.out.println("====" + element + "====");
        System.out.println(element.getKind() +
                " : " + element.getModifiers() +
                " : " + element.getSimpleName() +
                " : " + element.asType());
        if (element.getKind().equals(ElementKind.CLASS)) {
            TypeElement te = (TypeElement) element;
            System.out.println(te.getQualifiedName());
            System.out.println(te.getSuperclass());
            System.out.println(te.getEnclosedElements());
        }
        if (element.getKind().equals(ElementKind.METHOD)) {
            ExecutableElement ex = (ExecutableElement) element;
            System.out.print(ex.getReceiverType() + " ");
            System.out.print(ex.getSimpleName() + "(");
            System.out.print(ex.getParameters() + ")");
        }
    }
}
