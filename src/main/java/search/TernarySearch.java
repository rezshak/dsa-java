package main.java.search;

final class TernarySearch {

    int ternarySearch(int[] A, int target) {
        return ternarySearch(A, 0, A.length - 1, target);
    }

    int ternarySearch(int[] A, int left, int right, int target) {

        if (left > right) return -1;

        int partitionSize = (right - left) / 3;

        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        if (A[mid1] == target) return mid1;

        if (A[mid2] == target) return mid2;

        if (A[mid1] > target)
            return ternarySearch(A, left, mid1 - 1, target);

        if (A[mid1] < target && target < A[mid2])
            return ternarySearch(A, mid1 + 1, mid2 - 1, target);

        return ternarySearch(A, mid2 + 1, right, target);
    }

    int ternarySearchIterative(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int partitionSize = (right - left) / 3;
            int mid1 = left + partitionSize;
            int mid2 = right - partitionSize;

            if (A[mid1] == target) return mid1;

            if (A[mid2] == target) return mid2;

            if (A[mid1] > target) {
                right = mid1 - 1;
            } else if (A[mid1] < target && target < A[mid2]) {
                left = mid1 + 1;
                right = mid2 - 1;
            } else {
                left = mid2 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        final int[] arr1 = {1, 3, 7, 8, 9};

        TernarySearch ts = new TernarySearch();

        System.out.println("-- Ternary BinarySearch Recursive");
        System.out.println(ts.ternarySearch(arr1, 1));
        System.out.println(ts.ternarySearch(arr1, 9));
        System.out.println(ts.ternarySearch(arr1, 99));

        System.out.println("-- Ternary BinarySearch Iterative");
        System.out.println(ts.ternarySearchIterative(arr1, 1));
        System.out.println(ts.ternarySearchIterative(arr1, 9));
        System.out.println(ts.ternarySearchIterative(arr1, 99));

    }

}
