package Lesson_2;

public class lesson2task7 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};//обрабатываемый массив
        printArray(array);

        shiftArray(array, -6);
    }

    static void shiftArray(int[] array, int n){
        if (n != 0) {
            if (n > 0) {//смещение направо
                if (n > array.length) {
                    n %= array.length;
                }
                n = array.length - n;
            } else {//смещение налево
                n = -n;
                if (n > array.length) {
                    n %= array.length;
                }
            }

            for (int i = 0; i < n; i++) {
                int temp = array[0];
                for (int j = 1; j < array.length; j++) {
                    array[j - 1] = array[j];
                }
                array[array.length - 1] = temp;
            }
            printArray(array);
        }
        System.err.println("Смещение равно нулю!");
    }

    static void printArray(int inArray[]){
        for ( int i : inArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
