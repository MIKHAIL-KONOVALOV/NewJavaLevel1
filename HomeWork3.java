/* Java 1. HomeWork3
*  @author Konovalov Mihail
*  14.06.2019
*
*/
import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
        playGame(6);
    }

    static void playGame(int n) {       // n - Number of trys
        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();
        int newGame;
        do {
            System.out.println("Try to guess number from 0 to 10");
            int nmb = rnd.nextInt(11);
            int ans = 0;
            for (int i = 0; i < n ; i++) {
                ans = scn.nextInt();
                if (ans == nmb) {
                    System.out.println("You Win! My number was: " + nmb);
                    break;
                } else if (ans > nmb)
                    System.out.println("Your number bigger than my.");
                else if (ans < nmb)
                    System.out.println("Your number less than my.");
            }
            if (ans != nmb)
                System.out.println("You Loose! My number was: " + nmb);
            System.out.println("Play again? 1 - Yes Other - No");
            newGame = scn.nextInt();
        } while (newGame == 1);
    }
}
