package generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射，来使用潜在类型机制
 *
 * @author wangzhichao
 * @since 2020/01/09
 */
// 不去实现 Performs 接口
class Mime {
    public void walkAgainstTheWind() {
    }

    public void sit() {
        System.out.println("Pretending to sit");
    }

    public void pushInvisibleWalls() {
    }

    @Override
    public String toString() {
        return "Mine";
    }
}

// 不去实现 Performs 接口
class SmartDog {
    public void speak() {
        System.out.println("Woof!");
    }

    public void sit() {
        System.out.println("Sitting");
    }

    public void reproduce() {
    }
}

class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            Method speak = spkr.getMethod("speak");
            speak.invoke(speaker);
        } catch (Exception e) {
            System.out.println(speaker + " cannot speak");
        }

        try {
            Method sit = spkr.getMethod("sit");
            sit.invoke(speaker);
        } catch (Exception e) {
            System.out.println(speaker + " cannot sit");
        }
    }
}

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
}
