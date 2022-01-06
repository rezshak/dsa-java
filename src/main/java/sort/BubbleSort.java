package sort;

import java.util.Arrays;

final class BubbleSort {

    static final int[] ARR0 = {1, 3, 2};
    static final int[] ARR1 = {8, 6, 2, 4, 5, 8};
    static final int[] ARR2 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90, 12, 55, 82, 3, 29, 69, 13, 57, 73, 5};
    static final int[] ARR3 = {23, 7, 29, 79, 12, 41, 57, 72, 45, 82, 51, 10, 40, 85, 72, 13, 50, 90, 100, 6, 39, 100};

    void bubbleSort(int[] A) {
        int lastSortedIndex = A.length - 1;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < lastSortedIndex; i++) {
                if (A[i] > A[i + 1]) {
                    swap(A, i, i + 1);
                }
                sorted = false;
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
