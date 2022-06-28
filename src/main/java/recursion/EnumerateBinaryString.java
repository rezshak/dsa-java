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

    public static void main(String[] args) {
        List<String> perms = enumerate(3);
        System.out.println(perms);
    }

}