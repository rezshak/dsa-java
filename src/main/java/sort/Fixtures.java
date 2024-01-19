package main.java.sort;

final class Fixtures {

    private Fixtures() {}

    static final int[] NUMS1 = { 8, 6, 2, 4, 5, 8 };
    static final int[] NUMS2 = { 1, 3, 2 };
    static final int[] NUMS3 = { 7 };
    static final int[] NUMS4 = {};

    static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    
}
