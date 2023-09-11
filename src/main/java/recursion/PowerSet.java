package main.java.recursion;

import java.util.*;

public class PowerSet {

    static List<List<Integer>> subsetsBacktrack(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack1(nums, 0, curr, result);
        return result;
    }

    static void backtrack1(int[] nums, int start, List<Integer> curr, List<List<Integer>> result) {
        result.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack1(nums, i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    static void backtrack2(int[] nums, int i, List<Integer> curr, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        backtrack2(nums, i + 1, curr, result);
        curr.remove(curr.size() - 1);
        backtrack2(nums, i + 1, curr, result);
    }

    static List<List<Integer>> subsetsBitmask(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int count = (int) Math.pow(2, nums.length);
        for (int i = 0; i < count; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int x = i & (1 << j);
                if (x != 0) {
                    curr.add(nums[j]);
                }
            }
            result.add(curr);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4};
        var subsets = subsetsBitmask(nums);
        System.out.println(subsets);
    }

}
