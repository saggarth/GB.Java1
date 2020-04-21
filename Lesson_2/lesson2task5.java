package Lesson_2;

public class lesson2task5 {
    public static void main(String[] args) {
        int[] array = {1, 6, 3, 2, 11, 4, 5, 7, 0, 8, 9, 10};
        int max = array[0], min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
    }
}
