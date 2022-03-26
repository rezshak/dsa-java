package sort;

import java.util.Arrays;

final class CountingSort {

    static final int[] ARR0 = { 1, 3, 2 };
    static final int[] ARR1 = { 2, 5, 3, 1, 5 };

    public void countingSort(int[] A) {
        int max = Arrays.stream(A).max().getAsInt();
        int[] counts = new int[max + 1];
        for (int n : A) counts[n]++;
        int k = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                A[k++] = i;
            }
        }
    }

    void countingSortLegacy(int[] A) {
        int max = Arrays.stream(A).max().getAsInt();
        int[] counts = new int[max + 1];
        for (int n : A) counts[n]++;

        for (int i = 1; i <= max; i++) counts[i] += counts[i - 1];

        int[] sorted = new int[A.length];
        for (int i = sorted.length - 1; i >= 0; i--) {
            int origVal = A[i];
            int origValIdx = counts[A[i]] - 1;
            sorted[origValIdx] = origVal;
            counts[origVal]--;
        }

        System.arraycopy(sorted, 0, A, 0, A.length);
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        System.out.println("Original: " + Arrays.toString(ARR1));
        cs.countingSort(ARR1);
        System.out.println("Sorted: " + Arrays.toString(ARR1));
    }

}
