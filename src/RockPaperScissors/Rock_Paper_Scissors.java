package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissors {
    public static Scanner   sc          = new Scanner(System.in);
    public static int       score       = 0;
    public static int       gameCount   = 0;

    public static void play() {
        String computer = computerChoice();
        String user = userChoice();
        determineWinner(computer, user);
    }

    public static String computerChoice() {
        Random rand = new Random();
        int cinput = rand.nextInt(3) + 1;
        String computer = "thing";
        if (cinput == 1)
            computer = "Rock";
        if (cinput == 2)
            computer = "Paper";
        if (cinput == 3)
            computer = "Scissors";
        return computer;
    }

    public static boolean playAgain() {
        System.out.println("Play again?(y/n)");
        String input = sc.nextLine();
        if (input.toLowerCase().equals("y")) {
            return true;
        }
        else if (input.toLowerCase().equals("n")) {
            return false;
        }
        else {
            System.out.println("Invalid Input");
            return playAgain();
        }
    }

    public static String userChoice() {
        String user = "default";
        do {
            System.out.println("choose your weapon(Paper,Scissors or Rock)");
            user = sc.nextLine();
        }
        while (!isValidChoice(user));
        return user;
    }

    public static boolean isValidChoice(String choice) {
        boolean status;
        if (choice.equals("Rock"))
            status = true;
        else if (choice.equals("Paper"))
            status = true;
        else if (choice.equals("Scissors"))
            status = true;
        else {
            status = false;
            System.out.println("Error! Make sure you are capitalizing your choices");
        }
        return status;
    }

    public static void determineWinner(String computer, String user) {
        gameCount++;
        System.out.println(" Computer Choice: " + computer);
        System.out.println("Your Choice : " + user);
        if (computer.equals("Rock") && user.equals("Scissors")) {
            score--;
            System.out.println(" Computer wins! Better luck next time!");
        }
        if (computer.equals("Scissors") && user.equals("Paper")) {
            score--;
            System.out.println(" Computer wins! Better luck next time!");
        }
        if (computer.equals("Paper") && user.equals("Rock")) {
            score--;
            System.out.println(" Computer wins! Better luck next time!");
        }
        if (computer.equals("Rock") && user.equals("Paper")) {
            score++;
            System.out.println(" You win!!");
        }
        if (computer.equals("Scissors") && user.equals("Rock")) {
            score++;
            System.out.println(" You win!!");
        }
        if (computer.equals("Paper") && user.equals("Scissors")) {
            score++;
            System.out.println(" You win!!");
        }
        else if (computer.equals(user)) {
            System.out.println(" Tie! the game must be played again.");
        }
        System.out.println("We have matched wits " + gameCount + " times, and your score is " + score);
        return;
    }
}
