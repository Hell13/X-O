import java.util.Scanner;

public class Main {

    static final int MAX_FIELDS = 3;
    static final int MIN_FIELDS = 1;
    static int exitQuestion = 1;
    static char winner = ' ';
    static char[][] myFields = new char[MAX_FIELDS][MAX_FIELDS];


    public static void main (String[] args) {

        char playerIdentifier = ' ';
        Scanner exitId = new Scanner(System.in);
        System.out.println("Добро пожаловать на игру Крестики-Нолики!");
        while (exitQuestion == 1){
            clearFields();
            while (!checkIfGameIsOver(playerIdentifier) && checkForEmptyFields()) {
                if (playerIdentifier == 'X'){
                    playerIdentifier = 'O';
                } else {
                    playerIdentifier = 'X';
                }
                input(playerIdentifier);
                showScreen();
            }

            if (winner == 'X' || winner == 'O'){
                congratulations(winner);
            }else{
                System.out.println("Ничья!");
            }
            inputPlayAgain();

        }
    }

    static void clearFields(){

        for (int i = 0; i < MAX_FIELDS; i++){
            for (int j = 0; j < MAX_FIELDS; j++){
                myFields[i][j] = ' ';
            }
        }
    }

    static boolean checkIfGameIsOver(char playerId){

        if (myFields[0][0] == myFields[1][0] && myFields[1][0] == myFields[2][0] && myFields[2][0] != ' '){
            winner = playerId;
            return (true);
        } else if (myFields[0][1] == myFields[1][1] && myFields[1][1] == myFields[2][1] && myFields[2][1] != ' '){
            winner = playerId;
            return (true);
        } else if (myFields[0][2] == myFields[1][2] && myFields[1][2] == myFields[2][2] && myFields[2][2] != ' '){
            winner = playerId;
            return (true);
        } else if (myFields[0][0] == myFields[0][1] && myFields[0][1] == myFields[0][2] && myFields[0][2] != ' '){
            winner = playerId;
            return (true);
        } else if (myFields[1][0] == myFields[1][1] && myFields[1][1] == myFields[1][2] && myFields[1][2] != ' '){
            winner = playerId;
            return (true);
        } else if (myFields[2][0] == myFields[2][1] && myFields[2][1] == myFields[2][2] && myFields[2][2] != ' '){
            winner = playerId;
            return (true);
        } else if (myFields[0][0] == myFields[1][1] && myFields[1][1] == myFields[2][2] && myFields[2][2] != ' '){
            winner = playerId;
            return (true);
        } else if (myFields[2][0] == myFields[1][1] && myFields[1][1] == myFields[0][2] && myFields[0][2] != ' '){
            winner = playerId;
            return (true);
        } else {
            return (false);
        }
    }

    static void input(char identifier){

        Scanner inputValueX = new Scanner(System.in);
        Scanner inputValueY = new Scanner(System.in);
        System.out.println("Ход игрока " + identifier);
        int ifFieldIsEmpty = 1;
        int inputIntX = 0, inputIntY = 0;

        while (ifFieldIsEmpty == 1){
            System.out.print("Пожалуйста, введите X координату ячейки  (от 1 до 3): ");
            inputIntX = inputValueX.nextInt();
            while (inputIntX > MAX_FIELDS || inputIntX < MIN_FIELDS) {
                System.out.println();
                System.out.print("Вы ввели некорректное значение, пожалуйста, повторите попытку: ");
                inputIntX = inputValueX.nextInt();
            }

            System.out.print("Пожалуйста, введите Y координату ячейки  (от 1 до 3): ");
            inputIntY = inputValueX.nextInt();
            while (inputIntY > MAX_FIELDS || inputIntY < MIN_FIELDS) {
                System.out.println();
                System.out.print("Вы ввели некорректное значение, пожалуйста, повторите попытку: ");
                inputIntY = inputValueX.nextInt();
            }
            if (myFields[inputIntX-1][inputIntY-1] != ' '){
                System.out.println("Данное поле уже занято! Пожалуйста, введите другие координаты.");
            }else{
                ifFieldIsEmpty = 0;
            }
        }

        myFields[inputIntX-1][inputIntY-1] = identifier;
    }

    static void showScreen(){

        System.out.println("--------------------");
        System.out.println();
        System.out.println(myFields[0][0] + "|" + myFields[1][0] + "|" + myFields[2][0]);
        System.out.println("-+-+-");
        System.out.println(myFields[0][1] + "|" + myFields[1][1] + "|" + myFields[2][1]);
        System.out.println("-+-+-");
        System.out.println(myFields[0][2] + "|" + myFields[1][2] + "|" + myFields[2][2]);
        System.out.println();
        System.out.println("--------------------");
    }

    static void congratulations (char identifier){

        System.out.println("Поздравляем!!! Победитель  - игрок " + identifier);
    }

    static boolean checkForEmptyFields(){

        for (int i = 0; i < MAX_FIELDS; i++){
            for (int j = 0; j < MAX_FIELDS; j++){
                if (myFields[i][j] == ' '){
                    return (true);
                }
            }
        }
        return (false);
    }

    static void inputPlayAgain (){

        final int YES_ANSWER = 1, NO_ANSWER = 2;
        System.out.println("Не хотите ли сыграть еще раз? (1 - Yes / 2 - No): ");
        Scanner inputValue = new Scanner(System.in);
        exitQuestion = inputValue.nextInt();
        while (exitQuestion > NO_ANSWER || exitQuestion < YES_ANSWER) {
            System.out.println();
            System.out.print("Вы ввели некорректное значение, пожалуйста, повторите попытку: ");
            exitQuestion = inputValue.nextInt();
        }

    }

}
