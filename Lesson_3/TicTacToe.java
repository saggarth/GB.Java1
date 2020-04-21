package Lesson_3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] map;
    private static final int SIZE = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static boolean SILLY_MODE;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("Выберите режим игры: легкий - 1, сложный - 2");
        int diffSet = scanner.nextInt();

        if (diffSet == 1){
            SILLY_MODE = true;
            System.out.println("Выбран легкий режим игры.");
            System.out.println();
        } else if (diffSet == 2){
            SILLY_MODE = false;
            System.out.println("Выбран сложный режим игры");
            System.out.println();
        }

        initMap();
        printMap();

        while (true) {
            humanTurn();
            if (isEndGame(DOT_X)) {
                break;
            }
            computerTurn();
            if (isEndGame(DOT_O)) {
                break;
            }
        }
        System.out.println("Игра окончена");
    }

    //GAME FIELD - генерация игрового поля
    private static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    //PRINT GAME FIELD - отрисовка игрового поля
    private static void printMap(){
        for (int i = 0; i <= SIZE; i ++){
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i ++){
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //HUMAN TURN - ход игрока
    private static void humanTurn(){
        int x, y;
        do {
            System.out.println("Введите координаты ячейки через пробел:");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = DOT_X;
    }

    //AI TURN - ход компьютера
    private static void computerTurn(){
        int x = -1;
        int y = -1;

        if (SILLY_MODE) {//проверка сложности
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер выбрал ячейку " + (y + 1) + " " + (x + 1));
            map[y][x] = DOT_O;
        } else {
            for (int i = 0, key = 0; i < SIZE; i ++){
                for (int j = 0; j < SIZE; j++){
                    if (i == 0 && j == 0){//точка в левом верхнем углу
                        if ((map[i][j] == DOT_EMPTY && map[i][j+1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j+1] == DOT_O)) {
                            aiChoice(i, j);
                            key = 1;
                            break;
                        } else continue;
                    } else if (i == 0 && j > 0 && j < (SIZE - 1)){//точка в центре сверху
                        if ((map[i][j] == DOT_EMPTY && map[i][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i][j+1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j+1] == DOT_O)){
                            aiChoice(i,j);
                            key = 1;
                            break;
                        }
                    } else if (i == 0 && j > 0 && j == (SIZE - 1)){//точка в правом верхнем углу
                        if ((map[i][j] == DOT_EMPTY && map[i][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j] == DOT_O)){
                            aiChoice(i,j);
                            key = 1;
                            break;
                        } else continue;
                    } else if (i > 0 && i < (SIZE - 1) && j == 0){//точка в центре слева
                        if ((map[i][j] == DOT_EMPTY && map[i-1][j] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i-1][j+1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i][j+1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j+1] == DOT_O)){
                            aiChoice(i,j);
                            key = 1;
                            break;
                        } else continue;
                    } else if (i > 0 && i < (SIZE - 1) && j > 0 && j < (SIZE - 1)){//точка в центре
                        if ((map[i][j] == DOT_EMPTY && map[i-1][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i-1][j] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i-1][j+1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i][j+1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j+1] == DOT_O)){
                            aiChoice(i,j);
                            key = 1;
                            break;
                        } else continue;
                    } else if (i > 0 && i < (SIZE - 1) && j == (SIZE - 1)){//точка в центре справа
                        if ((map[i][j] == DOT_EMPTY && map[i-1][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i-1][j] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i+1][j] == DOT_O)){
                            aiChoice(i,j);
                            key = 1;
                            break;
                        } else continue;
                    } else if (i > 0 && i == (SIZE - 1) && j == 0){//точка в левом нижнем углу
                        if ((map[i][j] == DOT_EMPTY && map[i-1][j] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i-1][j+1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i][j+1] == DOT_O)){
                            aiChoice(i,j);
                            key = 1;
                            break;
                        } else continue;
                    } else if (i == (SIZE - 1) && j > 0 && j < (SIZE - 1)){//точка в центре снизу
                        if ((map[i][j] == DOT_EMPTY && map[i-1][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i-1][j] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i-1][j+1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i][j+1] == DOT_O)){
                            aiChoice(i,j);
                            key = 1;
                            break;
                        } else continue;
                    } else if (i == (SIZE - 1) && j == (SIZE - 1)){//точка в правом нижнем углу
                        if ((map[i][j] == DOT_EMPTY && map[i][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i-1][j-1] == DOT_O) ||
                            (map[i][j] == DOT_EMPTY && map[i-1][j] == DOT_O)) {
                            aiChoice(i, j);
                            key = 1;
                            break;
                        } else continue;
                    }
                }
                if (key == 1){
                    break;
                } else if (key == 0 && i == (SIZE - 1)){
                    do {
                        x = random.nextInt(SIZE);
                        y = random.nextInt(SIZE);
                    } while (!isCellValid(x, y));
                    aiChoice(y, x);
                    break;
                }
            }
        }
    }

    //CELL CHECK - проверка выбранной ячейки
    private static boolean isCellValid(int x, int y){
        boolean result = true;

        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE){
            result = false;
        }

        if (map[y][x] != DOT_EMPTY){
            result = false;
        }
        return result;
    }

    //GAME OVER
    private static boolean isEndGame(char playerSymbol){
        boolean result = false;

        printMap();

        if (checkWin(playerSymbol)){
            System.out.println("Победили " + playerSymbol);
            result = true;
        }

        else if (isMapFull()){
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    //MAP FULL
    private static boolean isMapFull(){
        boolean result = true;
        for (int i = 0; i < SIZE; i ++){
            for (int j = 0; j < SIZE; j++){
                if (map[i][j] == DOT_EMPTY){
                    result = false;
                    break;
                }
            }
            if (!result){
                break;
            }
        }
        return result;
    }

    //CHECK WIN
    private static boolean checkWin(char playerSymbol){
        boolean result = false;
        if ((map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
            (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
            (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
            (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
            (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
            (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
            (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
            (map[0][2] == playerSymbol && map[1][1] == playerSymbol && map[2][0] == playerSymbol)){
            result = true;
        }
        return result;
    }

    //AI CHOICE
    private static void aiChoice(int i, int j){
        System.out.println("Компьютер выбрал ячейку " + (i + 1) + " " + (j + 1));
        map[i][j] = DOT_O;
    }
}