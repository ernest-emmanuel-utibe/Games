import javax.swing.*;

public class GuessingGame {
    public static void main(String[] args) {
        int computeNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + computeNumber);
        int countNumber = 1;

        while(userAnswer != computeNumber) {
            String respond = JOptionPane.showInputDialog(null,
                    "Enter a guess between 1 and 100",
                    "Guessing Game", 3);
            userAnswer = Integer.parseInt(respond);
            JOptionPane.showMessageDialog(null,
                    ""+ determineGuess(userAnswer,
                            computeNumber, countNumber));
            computeNumber++;
        }
    }

    public static String determineGuess(int userAnswer,
                                        int computeNumber,
                                        int countNumber) {
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        }
        else if (userAnswer == computeNumber) {
            return "Correct\nTotal Guesses: "+ countNumber;
        }
        else if (userAnswer > computeNumber) {
            return "Your guess is too high, try again.\nTry number: "+ countNumber;
        } else if (userAnswer < computeNumber) {
            return "Your guess is too low, try again.\nTry number: "+ countNumber;
        }
        else {
            return "Your guess is incorrect\nTry number: "+ countNumber;
        }
    }
}
