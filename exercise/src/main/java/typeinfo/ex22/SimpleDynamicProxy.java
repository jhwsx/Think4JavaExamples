package typeinfo.ex22;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 动态代理
 *
 * @author wangzhichao
 * @date 2019/12/01
 */

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SomthingElse " + arg);
    }
}
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    private int doSomethingCount = 0;
    private int somethingElseCount = 0;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.print(" " + arg);
            }
        }
        if (method.getName().equals("doSomething")) {
            doSomethingCount++;
        } else if (method.getName().equals("somethingElse")) {
            somethingElseCount++;
        }
        return method.invoke(proxied, args);
    }

    public int getDoSomethingCount() {
        return doSomethingCount;
    }

    public int getSomethingElseCount() {
        return somethingElseCount;
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);

        DynamicProxyHandler h = new DynamicProxyHandler(realObject);
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                h);

        consumer(proxy);
        consumer(proxy);
        consumer(proxy);
        System.out.println("h.getDoSomethingCount() = " + h.getDoSomethingCount());
        System.out.println("h.getSomethingElseCount() = " + h.getSomethingElseCount());
    }
}
