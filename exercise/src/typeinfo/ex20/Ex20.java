package typeinfo.ex20;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * @author wangzhichao
 * @date 2019/12/01
 */
@Deprecated
public class Ex20 {
    public static void main(String[] args) {
        args = new String[]{String.class.getCanonicalName()};

        if (args.length == 0) {
            System.out.println("No args");
            System.exit(0);
        }
        String c = args[0];
        try {
            Class<?> clazz = Class.forName(c);
            Annotation[] annotations = clazz.getAnnotations();
            System.out.println("clazz.getAnnotations()");
            if (annotations.length == 0) {
                System.out.println("none");
            }
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
            }
            System.out.println("clazz.getCanonicalName(): " + clazz.getCanonicalName());
            Class<?>[] classes = clazz.getClasses();
            System.out.println("clazz.getClasses(): ");
            if (classes.length == 0) {
                System.out.println("none");
            }
            for (Class<?> cc : classes) {
                System.out.println(cc.getCanonicalName());
            }
            System.out.println("clazz.getClassLoader() = " + clazz.getClassLoader());
            Constructor<?>[] constructors = clazz.getConstructors();
            System.out.println("clazz.getConstructors() : ");
            if (constructors.length == 0) {
                System.out.println("none");
            } else {
                for (Constructor<?> constructor : constructors) {
                    System.out.println(constructor.toString());
                }
            }
            System.out.println("clazz.getComponentType() = " + clazz.getComponentType());
            Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
            System.out.println("clazz.getDeclaredAnnotations():");
            if (declaredAnnotations.length == 0) {
                System.out.println("none");
            } else {
                for (Annotation declaredAnnotation : declaredAnnotations) {
                    System.out.println(declaredAnnotation);
                }
            }
            Class<?>[] declaredClasses = clazz.getDeclaredClasses();
            System.out.println("clazz.getDeclaredClasses():");
            if (declaredClasses.length == 0) {
                System.out.println("none");
            } else {
                for (Class<?> declaredClass : declaredClasses) {
                    System.out.println(declaredClass);
                }
            }
            Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
            System.out.println("clazz.getDeclaredConstructors():");
            if (declaredConstructors.length == 0) {
                System.out.println("none");
            } else {
                for (Constructor<?> declaredConstructor : declaredConstructors) {
                    System.out.println(declaredConstructor);
                }
            }
            Field[] declaredFields = clazz.getDeclaredFields();
            System.out.println("clazz.getDeclaredFields():");
            if (declaredFields.length == 0) {
                System.out.println("none");
            } else {
                for (Field declaredField : declaredFields) {
                    System.out.println(declaredField);
                }
            }
            Method[] declaredMethods = clazz.getDeclaredMethods();
            System.out.println("clazz.getDeclaredMethods():");
            if (declaredMethods.length == 0) {
                System.out.println("none");
            } else {
                for (Method declaredMethod : declaredMethods) {
                    System.out.println(declaredMethod);
                }
            }
            System.out.println("clazz.getDeclaringClass() = " + clazz.getDeclaringClass());
            System.out.println("clazz.getEnclosingClass() = " + clazz.getEnclosingClass());
            System.out.println("clazz.getEnclosingConstructor() = " + clazz.getEnclosingConstructor());
            System.out.println("clazz.getEnclosingMethod() = " + clazz.getEnclosingMethod());
            System.out.println("clazz.getEnumConstants() = " + clazz.getEnumConstants());
            Field[] fields = clazz.getFields();
            System.out.println("clazz.getFields():");
            if (fields.length == 0) {
                System.out.println("none");
            } else {
                for (Field field : fields) {
                    System.out.println(field);
                }
            }
            Type[] genericInterfaces = clazz.getGenericInterfaces();
            System.out.println("clazz.getGenericInterfaces():");
            if (genericInterfaces.length == 0) {
                System.out.println("none");
            } else {
                for (Type genericInterface : genericInterfaces) {
                    System.out.println(genericInterface);
                }
            }
            System.out.println("clazz.getGenericSuperclass() = " + clazz.getGenericSuperclass());
            Class<?>[] interfaces = clazz.getInterfaces();
            System.out.println("clazz.getInterfaces():");
            if (interfaces.length == 0) {
                System.out.println("none");
            } else {
                for (Class<?> anInterface : interfaces) {
                    System.out.println(anInterface);
                }
            }
            Method[] methods = clazz.getMethods();
            System.out.println("clazz.getMethods():");
            if (methods.length == 0) {
                System.out.println("none");
            } else {
                for (Method method : methods) {
                    System.out.println(method);
                }
            }
            System.out.println("clazz.getModifiers() = " + clazz.getModifiers());
            System.out.println("Modifier.isPublic(clazz.getModifiers()) = " + Modifier.isPublic(clazz.getModifiers()));
            System.out.println("Modifier.isFinal(clazz.getModifiers()) = " + Modifier.isFinal(clazz.getModifiers()));
            System.out.println("clazz.getName() = " + clazz.getName());
            System.out.println("clazz.getPackage() = " + clazz.getPackage());
            System.out.println("clazz.getProtectionDomain() = " + clazz.getProtectionDomain());
            Object[] signers = clazz.getSigners();
            System.out.println("clazz.getSigners():");
            if (signers == null || signers.length == 0) {
                System.out.println("none");
            } else {
                for (Object signer : signers) {
                    System.out.println(signer);
                }
            }
            System.out.println("clazz.getSimpleName() = " + clazz.getSimpleName());
            System.out.println("clazz.getSuperclass() = " + clazz.getSuperclass());
            System.out.println("clazz.getTypeParameters() = " + clazz.getTypeParameters());
            System.out.println("clazz.isAnnotation() = " + clazz.isAnnotation());
            System.out.println("clazz.isAnonymousClass() = " + clazz.isAnonymousClass());
            System.out.println("clazz.isArray() = " + clazz.isArray());
            System.out.println("clazz.isEnum() = " + clazz.isEnum());
            System.out.println("clazz.isInterface() = " + clazz.isInterface());
            System.out.println("clazz.isPrimitive() = " + clazz.isPrimitive());
            System.out.println("clazz.isLocalClass() = " + clazz.isLocalClass());
            System.out.println("clazz.isMemberClass() = " + clazz.isMemberClass());
            System.out.println("clazz.isSynthetic() = " + clazz.isSynthetic());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
