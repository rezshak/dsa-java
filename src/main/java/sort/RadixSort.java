package main.java.sort;

import java.util.Arrays;

class RadixSort {

    void radixSort(int[] A) {
        int max = Arrays.stream(A).max().getAsInt();
        for (int place = 1; (max / place) > 0; place *= 10) {
            countingSort(A, place);
        }
    }

    void countingSort(int[] A, int place) {
        int max = Arrays.stream(A).max().getAsInt();
        int[] counts = new int[max + 1];

        for (int n : A) counts[(n / place) % 10]++;

        for (int i = 1; i < 10; i++) counts[i] += counts[i - 1];

        int[] sorted = new int[A.length];
        for (int i = sorted.length - 1; i >= 0; i--) {
            sorted[counts[(A[i] / place) % 10] - 1] = A[i];
            counts[(A[i] / place) % 10]--;
        }

        System.arraycopy(sorted, 0, A, 0, A.length);
    }

    public static void main(String[] args) {
        int[] arr1 = {8, 6, 4, 5, 11, 8};
        RadixSort rs = new RadixSort();
        rs.radixSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

}
