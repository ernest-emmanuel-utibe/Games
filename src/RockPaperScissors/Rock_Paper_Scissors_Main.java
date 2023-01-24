package RockPaperScissors;

import static RockPaperScissors.Rock_Paper_Scissors.*;

public class Rock_Paper_Scissors_Main {
    public static void main(String[] args) {
        play();
        while(playAgain()) {
            play();
        }
    }
}
