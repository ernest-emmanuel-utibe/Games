package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeMain {
    static TicTacToe game = new TicTacToe();
    public static  int count = 0;
    public static void main(String[] args) {
//        TicTacToe.TicTacToe ticTacToe = new TicTacToe.TicTacToe();


        game.displayBoard();


        while (count < 9) {
            game.player1();
            game.madeMoves[count] = game.movePosition;
            if (game.isWin()) {
                nextGame();
            }
            ++count;
            if (count == 9) {
                System.out.println("It's a draw");
                break;
            }
            game.player2();
            game.madeMoves[count] = game.movePosition;
            if (game.isWin()) {
                nextGame();
            }
            ++count;
        }
    }

    public static void nextGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you which to play again?");
        String answer = scanner.nextLine().toLowerCase();
        switch (answer) {
            case "yes" -> {
                game.clearBoard();
                count = 0;
                game.displayBoard();
                Arrays.fill(game.madeMoves, 0);

            }
            case "no" -> {System.exit(0);}
        }
    }
}
