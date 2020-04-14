package annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 列出在 PasswordUtils 中找到的用例，以及缺失的用例
 * 这里使用反射机制来查找@UseCase标记
 *
 * @author wangzhichao
 * @since 2020/4/13
 */
public class UseCaseTracker {
    public static void
    trackUseCases(List<Integer> useCases, Class<?> cl) {
        // getDeclaredMethods 返回本类声明的所有方法名的 Method 对象的数组
        for (Method m : cl.getDeclaredMethods()) {
            // 从 Method 对象上获取 UseCase 注解，不存在就返回的是 null
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() +
                        " " + uc.description());
                // 移除使用的用例
                useCases.remove(new Integer(uc.id()));
            }
        }

        // 打印剩余没有使用的用例
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
