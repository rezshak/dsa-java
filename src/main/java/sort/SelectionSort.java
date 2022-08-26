package main.java.sort;

import java.util.Arrays;

public class SelectionSort {

    static final int[] ARR0 = {1, 3, 2};
    static final int[] ARR1 = {8, 6, 2, 4, 5, 8};

    void selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            swap(A, i, minIndex);
        }
    }

    public static void main(String... args) {
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(ARR1);
        System.out.println(Arrays.toString(ARR1));
    }

    static void swap(int[] A, int i, int j) {
        if (i == j) return;
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
