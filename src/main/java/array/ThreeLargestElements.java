package main.java.array;

import java.util.Arrays;

final class ThreeLargestElements {

    int[] findThreeLargestNumbers(int[] A) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int n : A) {
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n > second) {
                third = second;
                second = n;
            } else if (n > third) {
                third = n;
            }
        }
        return new int[] { third, second, first };
    }

    public static void main(String[] args) {
        int[] ARR0 = { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 }; // 18, 141, 541
        ThreeLargestElements tle = new ThreeLargestElements();
        System.out.println(Arrays.toString(tle.findThreeLargestNumbers(ARR0)));
    }

}
