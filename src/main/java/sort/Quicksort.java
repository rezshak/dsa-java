package sort;

import java.util.Arrays;

final class Quicksort {

    static final int[] ARR0 = {8};
    static final int[] ARR1 = {8, 6, 2};
    static final int[] ARR2 = {8, 6, 2, 4, 5, 8, 9};
    static final int[] ARR3 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90};
    static final int[] ARR4 = {36, 72, 98, 98, 9, 60, 18, 60, 62, 74, 45, 62, 15, 55, 53, 100, 15, 21, 71, 48, 21, 43};

    void quicksort(int[] A, int lo, int hi) {

        if (lo < 0 || lo >= hi) {
            return;
        }

        int pi = hoarePartition(A, lo, hi);
        quicksort(A, lo, pi - 1);
        quicksort(A, pi + 1, hi);
    }

    // Hoare partition scheme
    int hoarePartition(int[] A, int lo, int hi) {

        int mid = (hi + lo) / 2;
        int pivot = A[mid];
        int i = lo - 1;
        int j = hi + 1;

        while (true) {

            do {
                i++;
            } while (A[i] < pivot);

            do {
                j--;
            } while (A[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(A, i, j);
        }
    }

    // Lomuto partition scheme
    int lomutoPartition(int[] A, int lo, int hi) {

        int pivot = A[hi];
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (A[j] <= pivot) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[hi];
        A[hi] = temp;

        return (i + 1);
    }

    public static void main(String... args) {

        Quicksort qs = new Quicksort();
        qs.quicksort(ARR1, 0, ARR1.length - 1);
        System.out.println(Arrays.toString(ARR1));

    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
