public class HwLesson1 {
    //Задание 1
    public static void main(String[] args) {

    //Задание 2
        byte varByte = 32;
        short varShort = 128;
        int varInt = 1024;
        long varLong = 1024L;
        float varFloat = 102.4f;
        double varDouble = 10.24;
        boolean varBool = true;
        char varChar = 'C';

    //Вывод результата для заданий 3-8
        System.out.println("3. Результат выражения: " + expression(4, 3, 5, 6));
        System.out.println("4. Результат сравнения: " + check(12, 12));
        System.out.println("5. Результат проверки: " + positive(-5));
        System.out.println("6. Результат проверки: " + negative(5));
        System.out.println("7. " + name("Нэо"));
        System.out.println("8. " + yearCheck(2029));
    }

    //Задание 3
    static int expression(int a, int b, int c, int d){
        return (a * (b + (c / d)));
    }

    //Задание 4
    static boolean check(int input1, int input2){
        boolean result;
        result = (input1 + input2) >= 10 && (input1 + input2) <= 20;
        return result;
    }

    //Задание 5
    static String positive(int number5){
        String numberCheck;
        if (number5 > 0){
            numberCheck = "Число положительное";
        } else {
            numberCheck = "Число отрицательное";
        }
        return numberCheck;
    }

    //Задание 6
    static boolean negative(int number6){
        return number6 < 0;
    }

    //Задание 7
    static String name(String name7){
        name7 = "Привет, " + name7 + "!";
        return name7;
    }

    //Задание 8
    static String yearCheck(int year8){
        String yearCheckResult;
        if ((((year8 % 4 == 0) && !(year8 % 100 == 0)) || (year8 % 400 == 0))) {
            yearCheckResult = "Год високосный";
        } else {
            yearCheckResult = "Год не високосный";
        }
        return yearCheckResult;
    }
}
