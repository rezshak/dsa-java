package recursion;

import java.util.*;

class EnumerateBinaryString {

    static List<String> enumerate(int n) {
        List<String> result = new ArrayList<>();
        enumerateHelper("", result, n);
        return result;
    }

    static void enumerateHelper(String slate, List<String> list, int n) {
        if (slate.length() == n) list.add(slate);
        else {
            enumerateHelper(slate + "0", list, n);
            enumerateHelper(slate + "1", list, n);
        }
    }

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

    public static void main(String[] args) {
        List<String> perms = enumerate(3);
        System.out.println(perms);
        perms = binaryStrings(3);
        System.out.println(perms);
    }

}
