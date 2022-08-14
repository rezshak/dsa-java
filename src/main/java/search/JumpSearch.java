package main.java.search;

class JumpSearch {

    int jumpSearch(int[] A, int target) {

        int len = A.length, blockSize = (int) Math.sqrt(len);
        int start = 0, next = blockSize;

        while (start < len && A[next - 1] < target) {
            start = next;
            next += blockSize;
            if (next > len) next = len;
        }

        for (int i = start; i < next; i++) {
            if (A[i] == target) return i;
        }

        return -1;
    }

    public static void main(String[] args) {

        JumpSearch js = new JumpSearch();

        final int[] arr1 = {1, 3, 7, 8, 9};

        System.out.println("-- Jump BinarySearch");
        System.out.println(js.jumpSearch(arr1, 1));
        System.out.println(js.jumpSearch(arr1, 9));
        System.out.println(js.jumpSearch(arr1, 99));
        System.out.println(js.jumpSearch(arr1, 2));

    }

}
