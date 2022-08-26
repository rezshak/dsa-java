package main.java.sort;

import java.util.Arrays;

public class BubbleSort {

    private static final int[] ARR1 = {1, 3, 2};
    private static final int[] ARR2 = {8, 6, 2, 4, 5, 8};
    private static final int[] ARR3 = {7};
    private static final int[] ARR4 = {};

    void bubbleSort(int[] A) {
        int lastSortedIndex = A.length - 1;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < lastSortedIndex; i++) {
                if (A[i] > A[i + 1]) {
                    swap(A, i, i + 1);
                    sorted = false;
                }
            }
            lastSortedIndex--;
        }
    }

    public static void main(String... args) {
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(ARR2);
        System.out.println(Arrays.toString(ARR2));
    }

    static void swap(int[] A, int i, int j) {
        if (i == j) return;
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
