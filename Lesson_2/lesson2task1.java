package Lesson_2;

public class lesson2task1 {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray(array);
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0){
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println();
        printArray(array);
    }
    static void printArray(int inArray[]){
        for ( int i = 0 ; i < inArray.length; i++) {
            System.out.print(inArray[i] + " ");
        }
    }
}
