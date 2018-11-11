package mypackage.Template;

import java.util.Random;

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

/**
 * 骰子dice
 * 硬币coin
 * 投掷
 */
interface gamePointThrow {
    int nextPoint();
}

interface gamePointThrowFactory {
    gamePointThrow getGame();
}

/**
 * A Games Framework using factory Methods
 */
public class Games {
    public static void playGame(GameFactory Factory) {
        Game s = Factory.getGame();
        while (s.move()) ;
    }

    public static void playTrowGame(gamePointThrowFactory factory) {
        gamePointThrow s = factory.getGame();
        System.out.println(s.nextPoint());
    }

    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
        playTrowGame(new diceFactory());
        playTrowGame((new coinFactory()));
    }
}

class dice implements gamePointThrow {
    @Override
    public int nextPoint() {
        System.out.println("Your dice point is:");
        return (new Random().nextInt(6)) + 1;
    }
}

class diceFactory implements gamePointThrowFactory {
    @Override
    public gamePointThrow getGame() {
        return new dice();
    }
}

class coin implements gamePointThrow {
    @Override
    public int nextPoint() {
        int point = new Random().nextInt(2);
        System.out.println("Your coin point is:" + (point == 1 ? "正面" : "反面"));
        return point;
    }
}

class coinFactory implements gamePointThrowFactory {
    @Override
    public gamePointThrow getGame() {
        return new coin();
    }
}

class Checkers implements Game {
    private static final int MOVES = 3;
    private int moves = 0;

    public boolean move() {
        System.out.println("Checkers moves" + moves);
        return ++moves != MOVES;
    }
}

class CheckersFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game {
    private static final int MOVE = 4;
    private int moves = 0;

    @Override
    public boolean move() {
        System.out.println("Chess move" + moves);
        return moves++ != MOVE;
    }
}

class ChessFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Chess();
    }

}