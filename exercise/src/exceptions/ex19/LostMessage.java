package exceptions.ex19;

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lostMessage = new LostMessage();
            try {
                lostMessage.f();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            } finally {
                lostMessage.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
