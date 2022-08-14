package main.java.search;

final class ExponentialSearch {

    int exponentialSearch(int[] A, int target) {

        int len = A.length, bound = 1;

        while (bound < len && A[bound] < target) bound *= 2;

        int left = bound;
        int right = Math.min(bound, len);

        BinarySearch bs = new BinarySearch();
        return bs.binarySearch(A, left, right, target);
    }

    public static void main(String[] args) {

        ExponentialSearch es = new ExponentialSearch();

        final int[] arr1 = {1, 3, 7, 8, 9};

        System.out.println("-- Jump BinarySearch");
        System.out.println(es.exponentialSearch(arr1, 1));
        System.out.println(es.exponentialSearch(arr1, 9));
        System.out.println(es.exponentialSearch(arr1, 99));
        System.out.println(es.exponentialSearch(arr1, 2));

    }

}
