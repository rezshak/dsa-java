package sort;

import java.util.Arrays;

final class CountingSort {

    static final int[] ARR0 = {1, 3, 2};
    static final int[] ARR1 = {8, 6, 2, 4, 5, 8};
    static final int[] ARR2 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90, 12, 55, 82, 3, 29, 69, 13, 57, 73, 5};
    static final int[] ARR3 = {23, 7, 29, 79, 12, 41, 57, 72, 45, 82, 51, 10, 40, 85, 72, 13, 50, 90, 100, 6, 39, 100};

    void countingSort(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) if (A[i] > max) max = A[i];
        int[] count = new int[max + 1];


    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        cs.countingSort(ARR1);
        System.out.println(Arrays.toString(ARR1));
    }

}