package main.java.sort;

import java.util.Arrays;

public class ShellSort {

    void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
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
