package main.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubArrays {

    static List<int[]> findSubArraysBf(int[] A, int target) {
        List<int[]> result = new ArrayList<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int currSum = 0;
            for (int j = i; j < len; j++) {
                currSum += A[j];
                if (currSum == target) {
                    int[] subarray = new int[j - i + 1];
                    System.arraycopy(A, i, subarray, 0, subarray.length);
                    result.add(subarray);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<int[]> subarrays = findSubArraysBf(arr, 9);
        for (int[] subarray : subarrays) {
            System.out.println(Arrays.toString(subarray));
        }
    }

}
