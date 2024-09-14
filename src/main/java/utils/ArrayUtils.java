package main.java.utils;

/**
 * Utility class providing common array operations.
 */
public final class ArrayUtils {

    private ArrayUtils() {
        throw new AssertionError("Cannot instantiate");
    }

    /**
     * Swaps the elements at the specified positions in the specified array.
     * If the specified positions are equal, invoking this method leaves
     * the array unchanged.
     *
     * @param nums the array in which to swap elements
     * @param i    the index of one element to be swapped
     * @param j    the index of the other element to be swapped
     * @throws ArrayIndexOutOfBoundsException if i or j are out of range
     */
    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            if (i < 0 || i >= nums.length || j < 0 || j >= nums.length) {
                throw new ArrayIndexOutOfBoundsException("Index out of range");
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
