package Java3Hw6;
import java.util.Arrays;

public class Hw6Main {
    public static void main(String[] args){
        int [] array0 = {4,5,8,9,13,34,1,3,18,4,1};
        int [] array14 = {1,4,4,1,1,4,1,4,1,1,2};
        Task1(array0);
        Task2(array14);
        System.out.println(Arrays.toString(Task1(array0)));
        System.out.println("В массиве 2 только 4 и 1: "+Task2(array14));

    }
    public static int[] Task1(int[] arr) throws RuntimeException {
        int n = 0;
        int k4 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                k4 = k4 + 1;
            }
        }
        if (k4 != 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 4) n = i;
            }
            int[] arr1 = new int[arr.length - n - 1];
            System.arraycopy(arr, n + 1, arr1, 0, arr1.length);
            return arr1;
        } else {
            throw new RuntimeException("В массиве отсутствует число 4");
        }
    }
    public static boolean Task2 (int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 || arr[i] != 4) {
                k = k + 1;
            }
        }
            if (k != 0) {
                return false;
            } else {
                return true;
        }
    }
}
