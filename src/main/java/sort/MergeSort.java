package sort;

import java.util.Arrays;

final class MergeSort {

    static final int[] ARR0 = { 8, 4 };
    static final int[] ARR1 = { 8, 6, 2 };
    static final int[] ARR2 = { 8, 6, 2, 4, 5, 8, 9 };
    static final int[] ARR3 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90 };
    static final int[] ARR4 = {36, 72, 98, 98, 9, 60, 18, 60, 62, 74, 45, 62, 15, 55, 53, 100, 15, 21, 71, 48, 21, 43};

    void mergeSort(int[] A) {
        if (A.length < 2) return;
        int len = A.length;
        int mid = len / 2;
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
