package sort;

import java.util.Arrays;

final class Quicksort {

    static final int[] ARR0 = {8};
    static final int[] ARR1 = {8, 6, 2};
    static final int[] ARR2 = {8, 6, 2, 4, 5, 8, 9};
    static final int[] ARR3 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90};
    static final int[] ARR4 = {36, 72, 98, 98, 9, 60, 18, 60, 62, 74, 45, 62, 15, 55, 53, 100, 15, 21, 71, 48, 21, 43};

    void quicksort(int[] A, int left, int right) {

        if (left < 0 || left >= right) {
            return;
        }

        int pivot = lomutoPartition(A, left, right);
        quicksort(A, left, pivot - 1);
        quicksort(A, pivot + 1, right);
    }

    int lomutoPartition(int[] A, int left, int right) {

        int pivot = A[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (A[j] <= pivot) {
                i++;
                swap(A, i, j);
            }
        }

        swap(A, i + 1, right);

        return (i + 1);
    }

    int hoarePartition(int[] A, int left, int right) {

        int mid = (right + left) / 2;
        int pivot = A[mid];
        int i = left - 1;
        int j = right + 1;

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

    public static void main(String... args) {
        Quicksort qs = new Quicksort();
        qs.quicksort(ARR3, 0, ARR3.length - 1);
        System.out.println(Arrays.toString(ARR3));
    }

    private static void swap(int[] A, int i, int j) {
        if (i == j) return;
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
