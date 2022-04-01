import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static int GCD(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < A.length; i++) {
            int gcd = getGCD(A[i - 1], A[i]);
            list.add(gcd);
        }
        Collections.sort(list);
        boolean found;
        for (int gcd : list) {
            found = true;
            for (int n : A) {
                found = (n % gcd == 0);
            }
            if (found) return gcd;
        }

        return 0;
    }

    private static int getGCD(int a, int b) {
        if (a == b) return a;
        else if (a > b) return getGCD(a - b, b);
        else return getGCD(a, b - a);
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] arr1 = { 51, 23 , 8, 61, 8, 11 };
        int[] arr2 = { 2, 5, 3, 1, 5 };
        int[] arr3 = { 5, 6, 7, 8, 9 };

        System.out.println(GCD(new int[]{156,84,60,1188,252}));

    }

}
