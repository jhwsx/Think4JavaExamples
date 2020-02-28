package polymorphism._16;

/**
 * @author wzc
 * @date 2019/7/14
 */
class AlertStatus {
    public void alert() {

    }
}

class FireStatus extends AlertStatus {
    @Override
    public void alert() {
        System.out.println("Fire,Fire");
    }
}

class SafeStatus extends AlertStatus {
    @Override
    public void alert() {
        System.out.println("Safe");
    }
}

class BreakStatus extends AlertStatus {
    @Override
    public void alert() {
        System.out.println("Break down");
    }
}

class StarShip {
    private AlertStatus status = new SafeStatus();
    public void changeFireStatus() {
        status = new FireStatus();
    }
    public void changeBreakStatus() {
        status = new BreakStatus();
    }
    public void changeSafeStatus() {
        status = new SafeStatus();
    }

    public void performAlert() {
        status.alert();
    }
}
public class Change {
    public static void main(String[] args) {
        StarShip starShip = new StarShip();
        starShip.performAlert();
        starShip.changeBreakStatus();
        starShip.performAlert();
        starShip.changeFireStatus();
        starShip.performAlert();
    }
}
