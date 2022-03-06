package sort;

import java.util.Arrays;

final class CountingSort {

    static final int[] ARR0 = {1, 3, 2};
    static final int[] ARR1 = {8, 6, 2, 4, 5, 8};
    static final int[] ARR2 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90, 12, 55, 82, 3, 29, 69, 13, 57, 73, 5};
    static final int[] ARR3 = {23, 7, 29, 79, 12, 41, 57, 72, 45, 82, 51, 10, 40, 85, 72, 13, 50, 90, 100, 6, 39, 100};

    void countingSort(int[] A) {

        int len = A.length, max = A[0];
        for (int i = 1; i < len; i++) if (A[i] > max) max = A[i];

        int[] count = new int[max + 1];
        for (int n : A) count[n]++;

        for (int i = 1; i <= max; i++) count[i] += count[i - 1];

        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            result[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }

        System.arraycopy(result, 0, A, 0, len);
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        System.out.println("Original: " + Arrays.toString(ARR2));
        cs.countingSort(ARR2);
        System.out.println("Sorted: " + Arrays.toString(ARR2));
    }

}
