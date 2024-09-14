package main.java.sort;

import java.util.Arrays;
import java.util.Random;

import static main.java.utils.ArrayUtils.swap;

public class QuickSortLomuto {

    private static final Random random = new Random();

    // T: O(nlogn), S: O(nlogn)
    void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIdx = lomutoPartition(nums, left, right);
            quickSort(nums, left, pivotIdx - 1);
            quickSort(nums, pivotIdx + 1, right);
        }
    }

    /**
     * Lomuto partition scheme, selecting the last element as the pivot and
     * rearranging elements so that all elements smaller than the pivot are on its
     * left and larger elements are on its right.
     * 
     * @return pivot index
     */
    public int lomutoPartition(int[] nums, int left, int right) {
        int randIdx = left + random.nextInt(right - left + 1);
        swap(nums, randIdx, right);
        int pivot = nums[right];
        int pi = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, pi, j);
                pi++;
            }
        }
        swap(nums, pi, right);
        return pi;
    }

    public static void main(String[] args) {
        var sorter = new QuickSortHoare();
        var nums1 = new int[] { 10, 7, 8, 9, 1, 5 };
        var nums2 = new int[] { 4, 3 };
        var nums3 = new int[] { 2 };
        var nums4 = new int[] {};

        System.out.println(Arrays.toString(nums1));
        sorter.quickSort(nums1);
        System.out.println(Arrays.toString(nums1));

        System.out.println(Arrays.toString(nums2));
        sorter.quickSort(nums2);
        System.out.println(Arrays.toString(nums2));

        System.out.println(Arrays.toString(nums3));
        sorter.quickSort(nums3);
        System.out.println(Arrays.toString(nums3));

        System.out.println(Arrays.toString(nums4));
        sorter.quickSort(nums4);
        System.out.println(Arrays.toString(nums4));
    }

}
