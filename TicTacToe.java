/* Java 1 Lesson 4. Game TicTacToe
* @author Konovalov Mihail
* 15.06.2019
* */
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    final int SIZE = 4;     // Размер поля
    final int N = 3;        // Сколько нужно в ряд для победы
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
        int aiX = 0, aiY = 0;
        boolean aiCanWin = false;
        boolean humanCanWin = false;

        for (int i = 0; i < map.length; i++ ) // Проход по пустым полям и проверка возможности победы Ai или человека
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_O;
                    if ( checkWin(DOT_O)){
                        aiCanWin = true;
                        aiX = i; aiY = j;
                        break;
                    }
                    map[i][j] = DOT_X;
                    if ( !humanCanWin && checkWin(DOT_X) ) {
                        aiX = i; aiY = j;
                        humanCanWin = true;
                    }
                    map[i][j] = DOT_EMPTY;

                }
            }
        if (aiCanWin || humanCanWin) // В случае возможности победы AI выигрывает или блокирует поле
            map[aiX][aiY] = DOT_O;
        else do {
                aiX = rnd.nextInt(SIZE);
                aiY = rnd.nextInt(SIZE);
            } while (!isCellValid(aiX, aiY));
            map[aiX][aiY] = DOT_O;
    }

    boolean checkWin(char dot) {
        return checkSquare(map,dot,N);
    }

    boolean checkSquare(char[][] square, char ch, int n) { // Проверк линий столбцов и диагоналей на n элем. подряд
        if ( checkLines(square,ch,n) || checkHoriz(square,ch,n) || checkDiag(square,ch,n) )
            return true;
        return false;
    }
    boolean checkDiag(char[][] square, char ch,int n) {
        boolean uldr = false;
        boolean dlur = false;
        for (int i = 0; i < (square.length - n + 1) && !uldr ; i++) {
            uldr = true;
            for (int j = i; j < (n + i) && uldr; j++) {
                uldr = square[j][j] == ch;
            }
        }
        for (int i = 0; i < (square.length - n + 1) && !dlur; i++) {
            dlur = true;
            for (int j = i; j < (n + i) && dlur; j++) {
                dlur = square[j][(square.length - j - 1)] == ch;
            }
        }
        return uldr || dlur;
    }

    boolean checkLines(char[][] square, char ch, int n) {
        boolean checkOk = false;
        for (int i = 0; i < square.length && !checkOk; i++) {  //Проход по строкам
            for (int j = 0; j < (square.length - n + 1) && !checkOk; j++) {  // Цикл в строке от начала до конца - n
                checkOk = true;
                for (int k = j; k < n +j && checkOk; k++) {
                    checkOk = square[i][k] == ch;
                }
            }
                if (checkOk)
                    return true;
        }
        return false;
    }

    boolean checkHoriz(char[][] square, char ch, int n) {
        boolean checkOk = false;
        for (int i = 0; i < square.length && !checkOk; i++) {  //Проход по столбцам
            for (int j = 0; j < (square.length - n + 1) && !checkOk; j++) {  // Цикл в столбце от начала до конца - n
                checkOk = true;
                for (int k = j; k < n + j && checkOk; k++) {
                    checkOk = square[k][i] == ch;
                }
            }
            if (checkOk)
                return true;
        }
        return false;
    }

//    boolean checkHoriz(char[][] square, char ch) {
//        for (int i = 0; i < square.length; i++) {
//            boolean checkOk = true;
//            for (int j = 0; j < square.length && checkOk; j++) {
//                checkOk = square[j][i] == ch;
//            }
//            if (checkOk)
//                return true;
//        }
//        return false;
//    }

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
