/* Java 1 Lesson 4. Game TicTacToe
* @author Konovalov Mihail
* 15.06.2019
* */
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    final int SIZE = 5;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner scn = new Scanner(System.in);
    Random rnd = new Random();

    public static void main(String[] args) {
        new TicTacToe().game(); // Создается объект и запускается метод game()
    }

    void game() {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            if (checkWin(DOT_X)) {
                System.out.println("You Win!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI Win!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
        }
        System.out.println("Game Over");
        printMap();
    }

    void initMap() {
        for (int i = 0; i < SIZE ; i++)
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
    }

    void printMap() {
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    void humanTurn() {
        int x,y;
        do {
            System.out.println("Enter x and y (1.." + SIZE + ")");
            x = scn.nextInt() - 1;
            y = scn.nextInt() - 1;
        } while (!isCellValid(x,y));
        map[x][y] = DOT_X;
    }

    void aiTurn() {
        int x,y;
        do {
            x = rnd.nextInt(3);
            y = rnd.nextInt(3);
        } while (!isCellValid(x,y));
        map[x][y] = DOT_O;
    }

    boolean checkWin(char dot) {
        return checkSquare(map,dot);
    }

    boolean checkSquare(char[][] square, char ch) {
        if ((checkLines(square,ch)) || (checkHoriz(square,ch)) || (checkDiag(square,ch)) )
            return true;
        return false;
    }
    boolean checkDiag(char[][] square, char ch) {
        boolean uldr = true;
        boolean dlur = true;
        for (int i = 0; i < square.length && uldr ; i++) {
            uldr = square[i][i] == ch;
        }
        for (int i = 0; i < square.length && dlur; i++) {
            dlur = square[(square.length - i - 1)][i] == ch;
        }
        return uldr || dlur;
    }

    boolean checkLines(char[][] square, char ch) {
        for (int i = 0; i < square.length; i++) {
            boolean checkOk = true;
            for (int j = 0; j < square.length && checkOk; j++) {
                checkOk = square[i][j] == ch;
            }
                if (checkOk)
                    return true;
        }
        return false;
    }

    boolean checkHoriz(char[][] square, char ch) {
        for (int i = 0; i < square.length; i++) {
            boolean checkOk = true;
            for (int j = 0; j < square.length && checkOk; j++) {
                checkOk = square[j][i] == ch;
            }
            if (checkOk)
                return true;
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE ; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if ((x < SIZE) && (y < SIZE) && (x >= 0) && (y >= 0) )
            if (map[x][y] == DOT_EMPTY)
                return true;
         return false;
    }
}
