package main.java.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayPermutations {

    static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        getPermutationsHelper(0, array, permutations);
        return permutations;
    }

    private static void getPermutationsHelper(int i, List<Integer> array, List<List<Integer>> permutations) {
        if (i == array.size() - 1) {
            permutations.add(new ArrayList<>(array));
        } else {
            for (int j = i; j < array.size(); j++) {
                swap(array, i, j);
                getPermutationsHelper(i + 1, array, permutations);
                swap(array, i, j);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 3);
        List<List<Integer>> permutations = getPermutations(array);
        System.out.println(permutations);
    }

    private static void swap(List<Integer> array, int i, int j) {
        Integer temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
