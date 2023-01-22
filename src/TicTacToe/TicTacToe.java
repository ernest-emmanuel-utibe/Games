package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    private Scanner scanner = new Scanner(System.in);
    private String[] moves = {"", "", "", "", "", "", "", "", "", ""};

    public int[]  madeMoves = new int[9];
    public int movePosition;

    public void displayBoard() {
        System.out.printf("""
                %3s  |%3s  |%3s
                -----+-----+-----
                %3s  |%3s  |%3s
                -----+-----+-----
                %3s  |%3s  |%3s%n%n""", moves[1], moves[2], moves[3],
                moves[4], moves[5], moves[6],
                moves[7], moves[8], moves[9]);
    }

    public void makeMove(String marker, int position) {
        moves[position] = marker;
    }

    public boolean itMoves(int position1, int position2, int position3) {
        boolean check = false;
        if (!moves[position1].equals("")) {
            if (moves[position1].equals(moves[position2]) && moves[position2].equals(moves[position3])) {
                check = true;
            }
        }
        return check;
    }

    public boolean isWin() {
        boolean won = false;
        if (itMoves(1, 2, 3)) {
            won = true;
        }
        if (itMoves(4, 5, 6)) {
            won = true;
        }
        if (itMoves(7, 8, 9)) {
            won = true;
        }
        if (itMoves(1, 4, 7)) {
            won = true;
        }
        if (itMoves(2, 5, 8)) {
            won = true;
        }
        if (itMoves(3, 6, 9)) {
            won = true;
        }
        if (itMoves(1, 5, 9)) {
            won = true;
        }
        if (itMoves(3, 5, 7)) {
            won = true;
        }
        return won;
    }

    public void player1() {
        System.out.print("Player 1 move: ");
        movePosition = scanner.nextInt();
        if (isValid(movePosition)) {
            makeMove("X", movePosition);
            System.out.println();
            displayBoard();
            if (isWin()) {
                System.out.println("Player 1 wins!!!");
            }
        } else {
            System.out.println("Make new move");
            player1();
        }
    }

    public void player2() {
        System.out.print("Player2 move: ");
        movePosition = scanner.nextInt();
        if (isValid(movePosition)) {
            makeMove("0", movePosition);
            System.out.println();
            displayBoard();
            if (isWin()) {
                System.out.println("Player 2 wins!!!");
            }
        }
        else {
            System.out.println("Make new move");
            player2();
        }
    }

    public boolean isValid(int position) {
        boolean valid = true;
        for (int i = 0; i < 9; i++){
            if (madeMoves[i] == position) {
                valid = false;
                break;
            }
        }
        if (position < 1 || position > 9) {
            valid = false;
        }
        return valid;
    }

    public void clearBoard() {
        Arrays.fill(moves, "");
    }
}
