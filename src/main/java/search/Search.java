package search;

import java.util.Arrays;

final class Search {

    int linearSearch(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) return i;
        }
        return -1;
    }

    int binarySearch(int[] A, int target) {
        return binarySearch(A, 0, A.length - 1, target);
    }

    int binarySearch(int[] A, int left, int right, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (A[mid] == target) return mid;
        if (A[mid] > target) return binarySearch(A, left, mid - 1, target);
        return binarySearch(A, mid + 1, right, target);
    }

    int binarySearchIterative(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) return mid;
            if (A[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

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

        Search search = new Search();

        System.out.println("-- Linear Search");
        System.out.println(search.linearSearch(arr1, 1));
        System.out.println(search.linearSearch(arr1, 9));
        System.out.println(search.linearSearch(arr1, 99));

        System.out.println("-- Binary Search Recursive");
        System.out.println(search.binarySearch(arr1, 1));
        System.out.println(search.binarySearch(arr1, 9));
        System.out.println(search.binarySearch(arr1, 99));

        System.out.println("-- Binary Search Iterative");
        System.out.println(search.binarySearchIterative(arr1, 1));
        System.out.println(search.binarySearchIterative(arr1, 9));
        System.out.println(search.binarySearchIterative(arr1, 99));

        System.out.println("-- Ternary Search Recursive");
        System.out.println(search.ternarySearch(arr1, 1));
        System.out.println(search.ternarySearch(arr1, 9));
        System.out.println(search.ternarySearch(arr1, 99));

        System.out.println("-- Ternary Search Iterative");
        System.out.println(search.ternarySearchIterative(arr1, 1));
        System.out.println(search.ternarySearchIterative(arr1, 9));
        System.out.println(search.ternarySearchIterative(arr1, 99));
    }

}
