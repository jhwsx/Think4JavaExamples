package annotations;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.Modifier;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 基于 apt 的注解处理
 * 参考：https://blog.csdn.net/sinat_36246371/article/details/53170166
 * todo 使用书上说的 apt -factory annotations.InterfaceExtractorProcessorFactory Multiplier.java-s ../annotations 怎么不可以
 *
 * @author wangzhichao
 * @since 2020/4/16
 */
public class InterfaceExtractorProcessor
        implements AnnotationProcessor {
    private final AnnotationProcessorEnvironment env;
    private ArrayList<MethodDeclaration> interfaceMethods =
            new ArrayList<>();

    public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env) {
        this.env = env;
    }

    @Override
    public void process() {
        for (TypeDeclaration typeDec1 : env.getSpecifiedTypeDeclarations()) {
            ExtractInterface annot = typeDec1.getAnnotation(ExtractInterface.class);
            if (annot == null) {
                break;
            }
            for (MethodDeclaration m : typeDec1.getMethods()) {
                if (m.getModifiers().contains(Modifier.PUBLIC) &&
                        !(m.getModifiers().contains(Modifier.STATIC))) {
                    // 修饰符包括 public 且不包括 static
                    interfaceMethods.add(m);
                }
            }
            // 这里开始创建接口
            if (interfaceMethods.size() > 0) {
                try {
                    // 我们可以通过 Filer 创建新的文件。
                    // 这里使用了 Filer 对象而不是普通的 PrintWriter，原因是，
                    // 只有这样 apt 才能知道我们创建的新文件，从而对新文件进行
                    // 注解处理，并且在需要的时候编译它们。
                    PrintWriter writer = env.getFiler().createSourceFile(annot.value());
                    writer.println("package " +
                            typeDec1.getPackage().getQualifiedName() + ";");
                    writer.println("public interface " +
                            annot.value() + " {");
                    for (MethodDeclaration m : interfaceMethods) {
                        writer.print("    public ");
                        // 返回值
                        writer.print(m.getReturnType() + " ");
                        // 方法名
                        writer.print(m.getSimpleName() + " (");
                        int i = 0;
                        // 参数列表
                        for (ParameterDeclaration parm : m.getParameters()) {
                            writer.print(parm.getType() + " " +
                                    parm.getSimpleName());
                            if (++i < m.getParameters().size()) {
                                writer.print(", ");
                            }
                        }
                        writer.println(");");
                    }
                    writer.println("}");
                    writer.close();
                } catch (IOException ioe) {
                    throw new RuntimeException(ioe);
                }
            }
        }
    }
}
