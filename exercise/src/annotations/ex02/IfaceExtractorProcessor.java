package annotations.ex02;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wangzhichao
 * @since 2020/5/15
 */
@SupportedAnnotationTypes("annotations.ex02.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class IfaceExtractorProcessor extends AbstractProcessor {
    private ArrayList<Element> interfaceMethods = new ArrayList<>();
    Elements elementUtils;
    private ProcessingEnvironment processingEnv;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
        // 获取一组静态方法的工具
        elementUtils = processingEnv.getElementUtils();
    }

    /**
     * 处理方法
     *
     * @param annotations 可以知道哪个注解是存在的
     * @param env         保留了剩余信息
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment env) {
        for (Element elem : env.getElementsAnnotatedWith(ExtractInterface.class)) {
            String interfaceName = elem.getAnnotation(ExtractInterface.class).interfaceName();
            // 过滤出公共非静态的成员方法
            for (Element enclosed : elem.getEnclosedElements()) {
                if (enclosed.getKind().equals(ElementKind.METHOD) &&
                        enclosed.getModifiers().contains(Modifier.PUBLIC) &&
                        !enclosed.getModifiers().contains(Modifier.STATIC)) {
                    interfaceMethods.add(enclosed);
                }
            }
            if (interfaceMethods.size() > 0) {
                writeInterfaceFile(interfaceName);
            }
        }
        return false;
    }

    /**
     * 生成接口定义
     *
     * @param interfaceName
     */
    private void writeInterfaceFile(String interfaceName) {
        try (
                // Filer是 getFiler() 生成的，并且是 PrintWriter 的一种实例，可以用于创建新文件。
                // 我们使用 Filer 对象，而不是原生的 PrintWriter 原因是，这个对象可以运行 javac 追踪你创建的新文件，
                // 这使得它可以在新一轮中检查新文件中的注解并编译文件。
                Writer writer = processingEnv.getFiler()
                        .createSourceFile(interfaceName)
                        .openWriter();
        ) {
            // 通过 elementUtils 来查找包名。
            String packageName = elementUtils
                    .getPackageOf(interfaceMethods.get(0)).toString();
            writer.write("package " + packageName + ";\n");
            writer.write("public interface " + interfaceName + "{\n");
            for (Element elem : interfaceMethods) {
                ExecutableElement method =
                        (ExecutableElement) elem;
                String signature = " public ";
                signature += method.getReturnType() + " ";
                signature += method.getSimpleName();
                signature += createArgList(method.getParameters());
                System.out.println(signature);
                writer.write(signature + ";\n");
            }
            writer.write("}");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 用于生成参数
     *
     * @param parameters
     * @return
     */
    private String createArgList(
            List<? extends VariableElement> parameters) {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0, parametersSize = parameters.size(); i < parametersSize; i++) {
            VariableElement parameter = parameters.get(i);
            sb.append(parameter.asType() + " " + parameter.getSimpleName());
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
