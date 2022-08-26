package main.java.sort;

import java.util.Arrays;

public class MergeSort {

    private static final int[] ARR1 = {1, 3, 2};
    private static final int[] ARR2 = {8, 6, 2, 4, 5, 8};
    private static final int[] ARR3 = {7};
    private static final int[] ARR4 = {};

    void mergeSort(int[] A) {
        if (A.length < 2) return;
        int len = A.length, mid = len / 2;
        int[] A1 = new int[mid];
        int[] A2 = new int[len - mid];
        System.arraycopy(A, 0, A1, 0, mid);
        System.arraycopy(A, mid, A2, 0, len - mid);
        mergeSort(A1);
        mergeSort(A2);
        merge(A, A1, A2);
    }

    void merge(int[] A, int[] A1, int[] A2) {
        int len1 = A1.length, len2 = A2.length;
        int idx = 0, idx1 = 0, idx2 = 0;
        while (idx1 < len1 && idx2 < len2) {
            A[idx++] = A1[idx1] <= A2[idx2] ? A1[idx1++] : A2[idx2++];
        }
        while (idx1 < len1) A[idx++] = A1[idx1++];
        while (idx2 < len2) A[idx++] = A2[idx2++];
    }

    public static void main(String... args) {
        MergeSort ms = new MergeSort();
        ms.mergeSort(ARR2);
        System.out.println(Arrays.toString(ARR2));
    }

}
