package sort;

import java.util.Arrays;

final class RadixSort {

    void radixSort(int[] A) {
        int max = Arrays.stream(A).max().getAsInt();
        // Apply counting sort to sort elements based on place value
        for (int place = 1; (max / place) > 0; place *= 10) {
            countingSort(A, place);
        }
    }

    // Using counting sort to sort the elements in the basis of significant places
    void countingSort(int[] A, int place) {

        int len = A.length;
        int max = Arrays.stream(A).max().getAsInt();
        int[] counts = new int[max + 1];

        for (int n : A) counts[(n / place) % 10]++;

        // Calculate cumulative count
        for (int i = 1; i < 10; i++) counts[i] += counts[i - 1];

        // Place the elements in sorted order
        int[] output = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            output[counts[(A[i] / place) % 10] - 1] = A[i];
            counts[(A[i] / place) % 10]--;
        }

        System.arraycopy(output, 0, A, 0, len);
    }

    public static void main(String[] args) {
        int[] arr1 = { 121, 432, 564, 23, 1, 45, 788 };
        int[] arr2 = { 18, 6, 12, 4, 5, 11, 21 };
        RadixSort rs = new RadixSort();
        rs.radixSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }


    private static void countingSort2(int[] A) {
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

}
