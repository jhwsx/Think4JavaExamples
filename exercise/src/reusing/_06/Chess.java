package reusing._06;

/**
 * @author wzc
 * @date 2019/6/16
 */
public class Chess extends BoardGame {

    Chess(int i) {
        super(i);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess chess = new Chess(11);
    }
}

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {

    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}
