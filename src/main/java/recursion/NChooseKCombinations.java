package main.java.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Given two integers n and k, find all the possible unique combinations of k numbers in range 1 to n.
 */
class NChooseKCombinations {

    public static List<List<Integer>> findCombinations(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        findCombinationsHelper(1, n, k, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void findCombinationsHelper(int start, int n, int k,
                                               List<Integer> combination, List<List<Integer>> combinations) {
        if (k == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n; i++) {
            combination.add(i);
            findCombinationsHelper(i + 1, n, k - 1, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findCombinations(5, 2));
    }

}
