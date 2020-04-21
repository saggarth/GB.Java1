package Lesson_2;

public class lesson2task6 {
    public static void main(String[] args) {
        int[] array = {2, 5, 0, 4, 5, 2, 4, 3, 1, 0, 0, 3, 3, 3, 2, 1, 0, 3, 2, 1};
        System.out.println(checkBalance(array));
    }
    static boolean checkBalance(int array[]){
        boolean result = false;
        int halfSum = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            halfSum += array[i];
        }
        if (halfSum % 2 == 0){
            for (int i = 0; i < array.length; i++){
                sum += array[i];
                if (sum == (halfSum / 2)){
                    result = true;
                }
            }
        }
        return result;
    }
}
