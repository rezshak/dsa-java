package main.java.string;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DnaPalindrome {

    private static final int BLOCK_SIZE = 6;
    private static final Map<Character, Character> COMPLEMENT = complementMap();

    private boolean isDnaPalindrome(String seq) {
        for (int i = 0; i <= seq.length() - BLOCK_SIZE; i++) {
            String block = seq.substring(i, BLOCK_SIZE);
            if (checkIfDnaPalindrome1(block)) return true;
        }

        return false;
    }

    // Mid-pointer approach
    private boolean checkIfDnaPalindrome1(String block) {
        int len = block.length(), mid = len / 2;
        int left = mid - 1, right = mid;
        while (left >= 0 && right <= len) {
            char leftCh = block.charAt(left--);
            char rightCh = block.charAt(right++);
            if (!COMPLEMENT.get(leftCh).equals(rightCh)) {
                return false;
            }
        }
        return true;
    }

    // Two-pointer approach
    private boolean checkIfDnaPalindrome2(String block) {
        int left = 0, right = block.length() - 1;
        while (left <= right) {
            char leftCh = block.charAt(left++);
            char rightCh = block.charAt(right--);
            if (!COMPLEMENT.get(leftCh).equals(rightCh)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DnaPalindrome dp = new DnaPalindrome();
        String seq1 = "ATCGAT";
        System.out.println(dp.isDnaPalindrome(seq1));
        String seq2 = "AAGCATGCTT";
        System.out.println(dp.isDnaPalindrome(seq2));
        String seq3 = "AAGCTTGCTT";
        System.out.println(dp.isDnaPalindrome(seq3));
    }

    private static Map<Character, Character> complementMap() {
        Map<Character, Character> complement = new HashMap<>();
        complement.put('A', 'T');
        complement.put('T', 'A');
        complement.put('C', 'G');
        complement.put('G', 'C');
        return complement;
    }


    @Test
    public void hasDnaPalindrome_seq1_shouldPass() {
        DnaPalindrome dp = new DnaPalindrome();
        String seq1 = "ATCGAT";
        assertTrue(dp.isDnaPalindrome(seq1));
    }

}
