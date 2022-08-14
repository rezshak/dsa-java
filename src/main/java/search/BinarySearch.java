package main.java.search;

class BinarySearch {

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

        final int[] arr1 = {1, 3, 7, 8, 9};

        BinarySearch bs = new BinarySearch();

        System.out.println("-- Binary BinarySearch Recursive");
        System.out.println(bs.binarySearch(arr1, 1));
        System.out.println(bs.binarySearch(arr1, 9));
        System.out.println(bs.binarySearch(arr1, 99));

        System.out.println("-- Binary BinarySearch Iterative");
        System.out.println(bs.binarySearchIterative(arr1, 1));
        System.out.println(bs.binarySearchIterative(arr1, 9));
        System.out.println(bs.binarySearchIterative(arr1, 99));

    }

}
