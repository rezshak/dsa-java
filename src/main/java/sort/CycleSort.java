package main.java.sort;

class CycleSort {

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

    public static void main(String[] args) {

        int[] arr1 = {12, 11, 15, 10, 9, 1, 2, 3, 13, 14, 4, 5, 6, 7, 8};
        int[] arr2 = {2, 1, 5, 2, 9, 1, 2, 3, 3, 4, 4, 5, 6, 7, 8};

        CycleSort cs = new CycleSort();
        cs.cycleSort(arr1);
        cs.cycleSort(arr2);

        System.out.println(java.util.Arrays.toString(arr1));
        System.out.println(java.util.Arrays.toString(arr2));
    }

}
