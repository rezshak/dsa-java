package main.java.recursion;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/*
 * Permute list of unique integers.
 */
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
        JUnitCore.main("recursion.Permutations");
    }

    private static void swap(List<Integer> array, int i, int j) {
        Integer temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    @Test
    public void getPermutations() {
        List<Integer> array = Arrays.asList(1, 2, 3);
        List<List<Integer>> permutations = getPermutations(array);
        assertTrue(permutations.contains(List.of(1, 2, 3)));
        assertTrue(permutations.contains(List.of(1, 3, 2)));
        assertTrue(permutations.contains(List.of(2, 1, 3)));
        assertTrue(permutations.contains(List.of(3, 2, 1)));
        assertTrue(permutations.contains(List.of(3, 1, 2)));
    }

}
