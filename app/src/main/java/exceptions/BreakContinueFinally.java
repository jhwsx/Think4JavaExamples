package exceptions;

public class BreakContinueFinally {
    public static void main(String[] args) {
        breakFinally();
        continueFinally();
    }

    private static void continueFinally() {
        int y = 0;
        try {
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    continue;
                }
                y++;
            }
        } finally {
            System.out.println("finally, y="+y);
            y = 0;
        }
    }

    static void breakFinally() {
        int x = 0;
        try {
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    break;
                }
                x++;
            }
        } finally {
            System.out.println("finally, x="+x);
            x = 0;
        }
    }
}
