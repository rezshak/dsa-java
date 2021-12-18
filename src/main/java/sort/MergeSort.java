package sort;

import java.util.Arrays;

final class MergeSort {

    static final int[] ARR0 = { 8 };
    static final int[] ARR1 = { 8, 6, 2 };
    static final int[] ARR2 = { 8, 6, 2, 4, 5, 8, 9 };
    static final int[] ARR3 = {6, 43, 48, 18, 62, 29, 26, 3, 22, 13, 17, 56, 90 };
    static final int[] ARR4 = {36, 72, 98, 98, 9, 60, 18, 60, 62, 74, 45, 62, 15, 55, 53, 100, 15, 21, 71, 48, 21, 43};

    void mergeSort(int[] nums) {

        if (nums.length < 2) {
            return;
        }

        int len = nums.length;
        int mid = len / 2;

        int[] nums1 = new int[mid];
        int[] nums2 = new int[len - mid];

        System.arraycopy(nums, 0, nums1, 0, mid);
        System.arraycopy(nums, mid, nums2, 0, len - mid);

        mergeSort(nums1);
        mergeSort(nums2);

        merge(nums, nums1, nums2);
    }

    void merge(int[] nums, int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int idx = 0, idx1 = 0, idx2 = 0;

        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] < nums2[idx2]) {
                nums[idx++] = nums1[idx1++];
            } else {
                nums[idx++] = nums2[idx2++];
            }
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
