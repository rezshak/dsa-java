package main.java.sort;

import java.util.Arrays;

public class CountingSort {

    private static final int[] ARR1 = { 3, 2, 3, 1, 5 };
    private static final int[] ARR2 = { 8, 6, 2, 4, 5, 8 };
    private static final int[] ARR3 = { 7 };
    private static final int[] ARR4 = {};

    void countingSort(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int range = max - min + 1;
        var counts = new int[range];
        for (int n : nums) {
            counts[n - min]++;
        }
        int k = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                nums[k] = i + min;
                k++;
                counts[i]--;
            }
        }
    }

    void countingSortLegacy(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        var counts = new int[max + 1];
        for (int n : nums) {
            counts[n]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        var sorted = new int[nums.length];
        for (int i = sorted.length - 1; i >= 0; i--) {
            int val = nums[i];
            int valSortedIdx = counts[val] - 1;
            sorted[valSortedIdx] = val;
            counts[val]--;
        }
        System.arraycopy(sorted, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        System.out.println("Original: " + Arrays.toString(ARR1));
        cs.countingSortLegacy(ARR1);
        System.out.println("Sorted: " + Arrays.toString(ARR1));
    }

}
