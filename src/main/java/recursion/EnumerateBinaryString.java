package main.java.recursion;

import java.util.*;

class EnumerateBinaryString {

    static List<String> enumerate(int n) {
        List<String> result = new ArrayList<>();
        enumerateHelper("", result, n);
        return result;
    }

    static void enumerateHelper(String slate, List<String> list, int n) {
        if (n == 0) list.add(slate);
        else {
            enumerateHelper(slate + "0", list, n - 1);
            enumerateHelper(slate + "1", list, n - 1);
        }
    }

    // Naive approach
    static List<String> binaryStrings(int n) {
        if (n == 1)
            return List.of("0", "1");
        else {
            List<String> prev = binaryStrings(n - 1);
            List<String> result = new ArrayList<>();
            for (String b : prev) {
                result.add(b + "0");
                result.add(b + "1");
            }
            return result;
        }
    }

    static List<String> binaryStringsIterative(int n) {
        List<String> result = List.of("0", "1");
        for (int i = 2; i <= n; i++) {
            List<String> slate = new ArrayList<>();
            for (String s : result) {
                slate.add(s + "0");
                slate.add(s + "1");
            }
            result = slate;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(enumerate(3));
        System.out.println(binaryStrings(3));
        System.out.println(binaryStringsIterative(3));
    }

}
