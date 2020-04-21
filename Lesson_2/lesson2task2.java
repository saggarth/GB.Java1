package Lesson_2;

public class lesson2task2 {
    public static void main(String[] args) {
        int[] array = new int[8];
        for ( int i = 0, j = 0; i < array.length; i++, j += 3) {
            array[i] = j;
        }
        for ( int i = 0 ; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
