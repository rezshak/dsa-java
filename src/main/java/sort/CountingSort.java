package sort;

import java.util.Arrays;

final class CountingSort {

    static final int[] ARR0 = {1, 3, 2};
    static final int[] ARR1 = {8, 6, 2, 4, 5, 8};
    static final int[] ARR2 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90, 12, 55, 82, 3, 29, 69, 13, 57, 73, 5};
    static final int[] ARR3 = {23, 7, 29, 79, 12, 41, 57, 72, 45, 82, 51, 10, 40, 85, 72, 13, 50, 90, 100, 6, 39, 100};

    void countingSort(int[] array) {

        int len = array.length;
        int[] result = new int[len + 1];

        // Find the largest element of the array
        int max = array[0];
        for (int i = 1; i < len; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        // Store the count of each element
        for (int i = 0; i < len; i++) {
            count[array[i]]++;
        }
        System.out.println("Count: " + Arrays.toString(count));

        // Store the cumulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in result array
        for (int i = len - 1; i >= 0; i--) {
            result[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < len; i++) {
            array[i] = result[i];
        }

    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        System.out.println("Original: " + Arrays.toString(ARR1));
        cs.countingSort(ARR1);
        System.out.println("Sorted: " + Arrays.toString(ARR1));
    }

}
