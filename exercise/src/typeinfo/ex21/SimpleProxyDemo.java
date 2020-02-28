package typeinfo.ex21;

/**
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

class SimpleProxy implements Interface {

    private Interface proxied;

    SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    private int doSomethingCount = 0;
    private int somethingElseCount = 0;
    @Override
    public void doSomething() {
        doSomethingCount++;
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        somethingElseCount++;
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }

    public int getDoSomethingCount() {
        return doSomethingCount;
    }

    public int getSomethingElseCount() {
        return somethingElseCount;
    }
}

public class SimpleProxyDemo {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        SimpleProxy iface = new SimpleProxy(new RealObject());
        consumer(iface);
        consumer(iface);
        consumer(iface);
        consumer(iface);
        System.out.println("iface.getDoSomethingCount() = " + iface.getDoSomethingCount());
        System.out.println("iface.getSomethingElseCount() = " + iface.getSomethingElseCount());

    }
}