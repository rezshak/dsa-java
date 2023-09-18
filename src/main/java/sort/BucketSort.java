package main.java.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BucketSort {

    static final int[] ARR1 = {8, 6, 2, 4, 5, 8, 9};
    static final int[] ARR2 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90};

    void bucketSort(int[] nums, int bucketsCount) {
        var buckets = createBuckets(bucketsCount);
        for (var n : nums) {
            var bucketIndex = n / bucketsCount;
            if (bucketIndex > bucketsCount) bucketIndex = buckets.size() - 1;
            buckets.get(bucketIndex).add(n);
        }
        var i = 0;
        for (var bucket : buckets) {

            Collections.sort(bucket);
            for (var n : bucket) {
                nums[i++] = n;
            }
        }
    }

    private List<List<Integer>> createBuckets(int bucketsCount) {
        var buckets = new ArrayList<List<Integer>>();
        for (var i = 0; i < bucketsCount; i++) {
            buckets.add(new ArrayList<>());
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
