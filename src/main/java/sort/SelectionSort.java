package sort;

import java.util.Arrays;

final class SelectionSort {

    static final int[] ARR0 = { 8, 6, 2, 4, 5, 8 };
    static final int[] ARR1 = { 6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90, 12, 55, 82, 3, 29, 69, 13, 57, 73, 5 };

    void selectionSort(int[] A) {

        for (int i = 0; i < A.length-1; i++) {
            int minIdx = i;
            int temp = A[i];
            for (int j = i+1; j < A.length; j++) {
                if (A[j] < A[minIdx]) {
                    minIdx = j;
                }
            }
            A[i] = A[minIdx];
            A[minIdx] = temp;
        }
    }

    public static void main(String... args) {
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(ARR1);
        System.out.println(Arrays.toString(ARR1));
    }
}
