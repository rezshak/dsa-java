package main.java.sort;

import java.util.*;

class BucketSort {

    static final int[] ARR1 = {8, 6, 2, 4, 5, 8, 9};
    static final int[] ARR2 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90};

    void bucketSort(int[] A, int numberOfBuckets) {
        var i = 0;
        for (var bucket : createBuckets(A, numberOfBuckets)) {
            Collections.sort(bucket);
            for (var item : bucket)
                A[i++] = item;
        }
    }

    List<List<Integer>> createBuckets(int[] A, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (var i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (var item : A) {
            int bucketIndex = item / numberOfBuckets;
            if (bucketIndex > numberOfBuckets) bucketIndex = numberOfBuckets - 1;
            buckets.get(bucketIndex).add(item);
        }

        return buckets;
    }

    public static void main(String[] args) {
        BucketSort bs = new BucketSort();
        System.out.println("Original: " + Arrays.toString(ARR2));
        bs.bucketSort(ARR2, 3);
        System.out.println("Sorted: " + Arrays.toString(ARR2));
    }

}
