package main.java.sort;

import java.util.Arrays;

public class MergeSort {

    private static final int[] ARR1 = {1, 3, 2};
    private static final int[] ARR2 = {8, 6, 2, 4, 5, 8};
    private static final int[] ARR3 = {7};
    private static final int[] ARR4 = {};

    void mergeSort(int[] A) {
        mergeSort(A, 0, A.length - 1);
    }

    void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    void merge(int[] nums, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];

        for (int i = 0; i < len1; i++) {
            nums1[i] = nums[left + i];
        }

        for (int j = 0; j < len2; j++) {
            nums2[j] = nums[mid + 1 + j];
        }

        int idx1 = 0, idx2 = 0;
        int idx = left;

        while (idx1 < len1 && idx2 < len2) {
            nums[idx++] = nums1[idx1] <= nums2[idx2] ? nums1[idx1++] : nums2[idx2++];
        }

        while (idx1 < len1) {
            nums[idx++] = nums1[idx1++];
        }

        while (idx2 < len2) {
            nums[idx++] = nums2[idx2++];
        }
    }

    public static void main(String... args) {
        MergeSort ms = new MergeSort();
        ms.mergeSort(ARR2);
        System.out.println(Arrays.toString(ARR2));
    }

}
