package generics.ex37;

import java.util.Date;

/**
 * 使用接口来实现混型效果
 *
 * @author wangzhichao
 * @since 2020/01/08
 */
interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Parcelabled {
    long getParcelable();
}

class ParcelabedImpl implements Parcelabled {
    private static long counter = 1;
    private final long parcelNumber = counter++;
    @Override
    public long getParcelable() {
        return parcelNumber;
    }
}

interface Basic {
    public void set(String val);

    public String get();
}

class BasicImp implements Basic {
    private String value;

    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

class Mixin extends BasicImp
        implements TimeStamped, SerialNumbered, Parcelabled {
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    private Parcelabled parcelabled = new ParcelabedImpl();
    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }

    @Override
    public long getParcelable() {
        return parcelabled.getParcelable();
    }
}

public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin();
        Mixin mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " +
                mixin1.getStamp() + " " + mixin1.getSerialNumber() + " " +
                mixin1.getParcelable());
        System.out.println(mixin2.get() + " " +
                mixin2.getStamp() + " " + mixin2.getSerialNumber() + " " +
                mixin2.getParcelable());
    }
}
