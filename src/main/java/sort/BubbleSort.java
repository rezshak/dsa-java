package main.java.sort;

import static main.java.sort.Fixtures.NUMS1;
import static main.java.sort.Fixtures.NUMS2;
import static main.java.sort.Fixtures.swap;

import java.util.Arrays;

final class BubbleSort {

    void bubbleSort(int[] A) {
        var lastSortedIndex = A.length - 1;
        var sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < lastSortedIndex; i++) {
                if (A[i] > A[i + 1]) {
                    swap(A, i, i + 1);
                    sorted = false;
                }
            }
            lastSortedIndex--;
        }
    }

    public static void main(String... args) {
        var bs = new BubbleSort();
        bs.bubbleSort(NUMS1);
        bs.bubbleSort(NUMS2);
        System.out.println(Arrays.toString(NUMS1));
        System.out.println(Arrays.toString(NUMS2));
    }

}
