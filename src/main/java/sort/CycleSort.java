package main.java.sort;

import java.util.Arrays;

public class CycleSort {

    private static final int[] ARR1 = {4, 3, 2, 1};
    private static final int[] ARR2 = {8, 6, 2, 4, 5, 8};
    private static final int[] ARR3 = {7};
    private static final int[] ARR4 = {};

    void cycleSort(int[] A) {

        int len = A.length;

        // traverse array elements and put it to on the right place
        for (int start = 0; start <= len - 2; start++) {
            // initialize item as starting point
            int item = A[start];

            // Find position where we put the item. We basically
            // count all smaller elements on right side of item.
            int pos = start;
            for (int i = start + 1; i < len; i++)
                if (A[i] < item)
                    pos++;

            // If item is already in correct position
            if (pos == start)
                continue;

            // ignore all duplicate elements
            while (item == A[pos])
                pos++;

            // put the item to it's right position
            if (pos != start) {
                int temp = item;
                item = A[pos];
                A[pos] = temp;
            }

            // Rotate rest of the cycle
            while (pos != start) {
                pos = start;

                // Find position where we put the element
                for (int i = start + 1; i < len; i++)
                    if (A[i] < item)
                        pos++;

                // ignore all duplicate elements
                while (item == A[pos])
                    pos++;

                // put the item to it's right position
                if (item != A[pos]) {
                    int temp = item;
                    item = A[pos];
                    A[pos] = temp;
                }
            }
        }
    }

    void cycleSort2(int[] arr) {
        int n = arr.length;
        int i = 0;

        while (i < n) {
            if (arr[i] != i + 1) {
                // The element is not in its correct position
                // Swap arr[i] with the element at index arr[i] - 1
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            } else {
                // The element is already in its correct position
                i++;
            }
        }
    }

    public static void main(String[] args) {
        var cs = new CycleSort();
        cs.cycleSort(ARR2);
        System.out.println(Arrays.toString(ARR2));

        cs.cycleSort(ARR1);
        System.out.println(Arrays.toString(ARR1));
    }

}
