package exceptions.ex18;

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very import exception";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

class SmallException extends Exception {
    @Override
    public String toString() {
        return "A small exception";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    void discard() throws SmallException {
        throw new SmallException();
    }

    public static void main(String[] args) {
        LostMessage lostMessage = new LostMessage();
        try {
            try {
                try {
                    lostMessage.f();
                } finally {
                    lostMessage.dispose();
                }
            } finally {
                lostMessage.discard();
            }
        } catch (VeryImportantException e) {
            e.printStackTrace();
        } catch (HoHumException e) {
            e.printStackTrace();
        } catch (SmallException e) {
            e.printStackTrace();
        }
    }
}
