package main.java.search;

class LinearSearch {

    int linearSearch(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        final int[] arr1 = {1, 3, 7, 8, 9};

        LinearSearch ls = new LinearSearch();

        System.out.println("-- Linear BinarySearch");
        System.out.println(ls.linearSearch(arr1, 1));
        System.out.println(ls.linearSearch(arr1, 9));
        System.out.println(ls.linearSearch(arr1, 99));

    }

}
