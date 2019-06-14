/* Java 1. HomeWork3
*  @author Konovalov Mihail
*  14.06.2019
*
*/
import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
//  Play Numbers      playGameNumbers(6);
//  Play Words      playGameWords();
    }

    static void playGameNumbers(int n) {       // n - Number of trys
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

    static void playGameWords() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        String aiWord, userWord;
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        aiWord = words[rnd.nextInt(25)];
        System.out.println("What word i think?");
        do {
            userWord = scn.next();
            if (userWord.equals(aiWord)) {
                System.out.println("You Win! My word was: " + aiWord);
            } else System.out.println(compare(aiWord,userWord));
        } while (!userWord.equals(aiWord));
    }

    static String compare(String a, String b) { //Сравнивание двух слов и вывод одинаковых символов
        String finalString = "";
        for (int i = 0; i < 15 ; i++) {
            if ((i < a.length()) & (i < b.length())){
                if (a.charAt(i) == b.charAt(i)){
                    finalString = finalString + a.charAt(i);
                    continue;
                } else {
                    finalString = finalString + "#";
                    continue;
                }
            }
            finalString = finalString + "#";
        }
        return finalString;
    }
}
