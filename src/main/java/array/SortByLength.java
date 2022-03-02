package array;

import java.util.Arrays;
import java.util.Comparator;

public class SortByLength {

    public static String sortByLength(String str) {
        String[] tempArr = str.split(" ");
        Arrays.sort(tempArr, Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase));
        return String.join(" ", tempArr);
    }

    public static void main(String[] args) {
        String s1 = "Three can keep a secret, if two of them are dead";
        String s2 = "a if of are can two dead keep them Three secret,";
        System.out.println(sortByLength(s1));
    }

}
