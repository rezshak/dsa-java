package sort;

import java.util.Arrays;

final class CountingSort {

    static final int[] ARR0 = {1, 3, 2};
    static final int[] ARR1 = {8, 6, 2, 4, 5, 8};

    void countingSort(int[] A) {

        int len = A.length;
        int max = Arrays.stream(A).max().getAsInt();

        int[] count = new int[max + 1];
        for (int n : A) count[n]++;

        for (int i = 1; i <= max; i++) count[i] += count[i - 1];

        int[] sorted = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int origVal = A[i];
            int origValIdx = count[A[i]] - 1;
            sorted[origValIdx] = origVal;
            count[origVal]--;
        }

        System.arraycopy(sorted, 0, A, 0, len);
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        System.out.println("Original: " + Arrays.toString(ARR1));
        cs.countingSort(ARR1);
        System.out.println("Sorted: " + Arrays.toString(ARR1));
    }

}
