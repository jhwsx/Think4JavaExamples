package exceptions.ex30;


import java.io.FileNotFoundException;
import java.io.IOException;

class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new Annoyance();
                case 1:
                    throw new Sneeze();
                case 2:
                    throw new RuntimeException("Where am I?");
                default:
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        wce.throwRuntimeException(3);
        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3) {
                    wce.throwRuntimeException(i);
                } else {
                    throw new RuntimeException();
                }
            }catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (Sneeze e) {
                    System.out.println("Sneeze: " + e);
                } catch (Annoyance e) {
                    System.out.println("Annoyance: " + e);
                } catch (Throwable e) {
                    System.out.println("Throwable: " + e);
                }
            }
        }
    }
}
