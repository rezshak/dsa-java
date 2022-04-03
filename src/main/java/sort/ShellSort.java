package sort;

import java.util.Arrays;

final class ShellSort {

    // Rearrange elements at each len/2, len/4, len/8, ... intervals
    void shellSort(int[] A) {
        int len = A.length;
        for (int interval = len / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < len; i += 1) {
                int temp = A[i];
                int j;
                for (j = i; j >= interval && A[j - interval] > temp; j -= interval) {
                    A[j] = A[j - interval];
                }
                A[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 18, 6, 12, 4, 5, 11, 21 };
        int[] arr2 = { 9, 8, 3, 7, 5, 6, 4, 1 };
        ShellSort ss = new ShellSort();
        ss.shellSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}