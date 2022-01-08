package dp;

import java.util.Arrays;

final class Fibonacci {

    // time: Ω(n), Θ(n), O(n); space: O(n)
    int[] fibonacciDynamic(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }

    // time: Ω(n), Θ(n), O(n); space: O(1)
    int fibonacciIterative(int n) {
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    // time: Ω(2^n), Θ(2^n), O(2^n); space: O(n)
    int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(Arrays.toString(f.fibonacciDynamic(10)));
        System.out.println(f.fibonacciIterative(8));
        System.out.println(f.fibonacciRecursive(8));
    }

}
