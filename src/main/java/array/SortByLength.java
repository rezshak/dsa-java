package array;

import java.util.Arrays;
import java.util.Comparator;

public class SortByLength {

    public static String singleOccurrence(String s) {
        if (s == null || s.isEmpty()) return "";
        int[] alph = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toUpperCase(s.charAt(i));
            alph[ch]++;
        }
        for (int i = 0; i < alph.length; i++) {
            if (alph[i] == 1) return (char) i + "";
        }
        return "";
    }

    public static void main(String[] args) {
        String s1 = "Three can keep a secret, if two of them are dead";
        String s2 = "a if of are can two dead keep them Three secret,";
        System.out.println(singleOccurrence("TeEsShHAa"));
    }

}
