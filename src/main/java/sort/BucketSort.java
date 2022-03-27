package sort;

import java.util.*;

final class BucketSort {

    static final int[] ARR1 = {8, 6, 2, 4, 5, 8, 9};
    static final int[] ARR2 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90};

    void bucketSort(int[] A) {
        int numberOfBuckets = A.length / 2;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int n : A) {
            int bucketIndex = n / numberOfBuckets;
            if (bucketIndex >= buckets.size()) bucketIndex = buckets.size() - 1;
            buckets.get(bucketIndex).add(n);
        }

        for (int i = 0; i < numberOfBuckets; i++) {
            List<Integer> bucket = buckets.get(i);
            Collections.sort(bucket);
        }

        int k = 0;
        for (int i = 0; i < numberOfBuckets; i++) {
            List<Integer> bucket = buckets.get(i);
            for (int n : bucket) {
                A[k++] = n;
            }
        }
    }

    public static void main(String[] args) {
        BucketSort bs = new BucketSort();
        System.out.println("Original: " + Arrays.toString(ARR2));
        bs.bucketSort(ARR2);
        System.out.println("Sorted: " + Arrays.toString(ARR2));
    }

}
