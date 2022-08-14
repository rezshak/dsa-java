package main.java.recursion;

import java.util.ArrayList;
import java.util.List;

public final class LetterCasePermutations {

    static List<String> letterCasePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        letterCasePermutationsHelper(0, str.toLowerCase().toCharArray(), permutations);
        return permutations;
    }

    private static void letterCasePermutationsHelper(int i, char[] arr, List<String> permutations) {
        if (i < arr.length) {
            letterCasePermutationsHelper(i + 1, arr, permutations);
            if (Character.isLetter(arr[i])) {
                arr[i] = Character.toUpperCase(arr[i]);
                letterCasePermutationsHelper(i + 1, arr, permutations);
                arr[i] = Character.toLowerCase(arr[i]);
            }
        } else {
            permutations.add(new String(arr));
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutations("a1z"));
    }

}
