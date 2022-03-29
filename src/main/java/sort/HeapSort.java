package sort;

import java.util.Arrays;

final class HeapSort {

    void heapSort(int[] A) {

        int len = A.length;

        // Build max heap (rearrange array)
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(A, len, i);
        }

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

        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < len && A[left] > A[largest]) largest = left;
        
        // If right child is larger than largest so far
        if (right < len && A[right] > A[largest]) largest = right;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            swap(A, i, largest);
            heapify(A, len, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 12, 9, 1, 7, 7, 10 };
        HeapSort hs = new HeapSort();
        System.out.println("Orig: " + Arrays.toString(arr1));
        hs.heapSort(arr1);
        System.out.println("Sorted: " + Arrays.toString(arr1));
    }

    static void swap(int[] A, int i, int j) {
        if (i == j) return;
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
