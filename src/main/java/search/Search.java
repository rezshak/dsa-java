package search;

import java.util.Arrays;

final class Search {

    final static int[] ARR1 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90};

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

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.linearSearch(ARR1, 90));
        System.out.println(search.linearSearch(ARR1, 91));

        Arrays.sort(ARR1);
        System.out.println(search.binarySearch(ARR1, 90));
        System.out.println(search.binarySearch(ARR1, 91));

        Arrays.sort(ARR1);
        System.out.println(search.binarySearchIterative(ARR1, 90));
        System.out.println(search.binarySearchIterative(ARR1, 91));
    }

}
