package main.java.sort;

import java.util.Arrays;

class Heapsort {

    void heapsort(int[] A) {
        int len = A.length;
        // Build max heap (rearrange array)
        for (int i = len / 2 - 1; i >= 0; i--)
            heapify(A, len, i);

        // Heap sort
        for (int i = len - 1; i >= 0; i--) {
            swap(A, i, 0);
            heapify(A, i, 0);
        }
    }

    // Parent (p) of element i: (i - 1) / 2
    // Left child of i: (2 * p) + 1
    // Right child of i: (2 * p) + 2
    void heapify(int[] A, int len, int i) {

        // Find largest among root, left child and right child
        int maxIdx = i;
        int leftChildIdx = (2 * i) + 1;
        int rightChildIdx = (2 * i) + 2;

        // If left child is larger than max so far, bubble it up
        if (leftChildIdx < len && A[leftChildIdx] > A[maxIdx])
            maxIdx = leftChildIdx;

        // If right child is larger than max so far, bubble it up
        if (rightChildIdx < len && A[rightChildIdx] > A[maxIdx])
            maxIdx = rightChildIdx;

        // Swap and continue heapifying if root is not maxIdx
        if (maxIdx != i) {
            swap(A, i, maxIdx);
            heapify(A, len, maxIdx);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 12, 9, 1, 7, 7, 10};
        Heapsort hs = new Heapsort();
        System.out.println("Orig: " + Arrays.toString(arr1));
        hs.heapsort(arr1);
        System.out.println("Sorted: " + Arrays.toString(arr1));
    }

    static void swap(int[] A, int i, int j) {
        if (i == j) return;
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
