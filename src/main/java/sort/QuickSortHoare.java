package main.java.sort;

import java.util.Arrays;

import static main.java.utils.ArrayUtils.swap;

public class QuickSortHoare {

    // T: O(nlogn), S: O(nlogn)
    void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partitionIdx = hoarePartition(nums, left, right);
            quickSort(nums, left, partitionIdx);
            quickSort(nums, partitionIdx + 1, right);
        }
    }

    /*
     * hoarePartition Method: Implements Hoare's partitioning scheme, which selects
     * a pivot (in this case, the middle element) and then rearranges the array such
     * that elements less than the pivot are on its left and elements greater are on
     * its right.
     */
    public int hoarePartition(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = nums[mid];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (nums[i] < pivot);
            do {
                j--;
            } while (nums[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(nums, i, j);
        }
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
