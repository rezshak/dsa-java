package main.java.sort;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {

    private static final int[] ARR1 = {1, 3, 2};
    private static final int[] ARR2 = {8, 6, 2, 4, 5, 8};
    private static final int[] ARR3 = {7};
    private static final int[] ARR4 = {};

    void quicksort(int[] A) {
        quicksort(A, 0, A.length - 1);
    }

    void quicksort(int[] A, int left, int right) {
        if (left < right) {
            int boundary = hoarePartition(A, left, right);
            quicksort(A, left, boundary); // hoare: pivot, lomuto: boundary - 1
            quicksort(A, boundary + 1, right);
        }
    }

    int lomutoPartition(int[] A, int left, int right) {
        int randIdx = new Random().nextInt(right - left) + left;
        swap(A, randIdx, right);
        int pivot = A[right];
        int boundary = left - 1;
        for (int i = left; i <= right; i++) {
            if (A[i] <= pivot) {
                boundary++;
                swap(A, i, boundary);
            }
        }
        return boundary;
    }

    int hoarePartition(int[] A, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = A[mid];
        int i = left - 1, j = right + 1;
        while (true) {
            do {
                i++;
            } while (A[i] < pivot);
            do {
                j--;
            } while (A[j] > pivot);
            if (i < j) swap(A, i, j);
            else return j;
        }
    }

    public static void main(String... args) {
        Quicksort qs = new Quicksort();
        qs.quicksort(ARR2);
        System.out.println(Arrays.toString(ARR2));
    }

    private static void swap(int[] A, int i, int j) {
        if (i == j) return;
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
