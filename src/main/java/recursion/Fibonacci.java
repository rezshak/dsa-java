package main.java.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Fibonacci {

    // Time: Ω(n), Θ(n), O(n); Space: O(n)
    int[] fibonacciDynamic(int n) {
        int[] fibs = new int[n + 1];
        fibs[0] = 0;
        fibs[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        return fibs;
    }

    // Time: Ω(n), Θ(n), O(n); Space: O(1)
    int fibonacciDynamicOptimized(int n) {
        int[] fibs = new int[3];
        fibs[0] = 0;
        fibs[1] = 1;
        for (int i = 2; i <= n; i++) {
            int fib = fibs[(i - 1) % 3] + fibs[(i - 2) % 3];
            fibs[i % 3] = fib;
        }
        return fibs[n % 3];
    }

    // Time: Ω(n), Θ(n), O(n); Space: O(1)
    int fibonacciIterative(int n) {
        int fib = 0, a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

    // Time: Ω(2^n), Θ(2^n), O(2^n); Space: O(n)
    int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) return n;
        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }

    // Time: Ω(n), Θ(n), O(n); Space: O(n)
    int fibonacciRecursiveDynamic(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        if (n == 0 || n == 1) return n;
        cache.put(n, fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1));
        return cache.get(n);
    }

    // Time: Ω(n), Θ(n), O(n); Space: O(n)
    int fibAdditiveSequence(int n, int a, int b) {
        if (n == 0) return a;
        return fibAdditiveSequence(n - 1, b, a + b);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(Arrays.toString(f.fibonacciDynamic(10)));
        System.out.println(f.fibonacciIterative(8));
        System.out.println(f.fibonacciRecursive(8));
        System.out.println(f.fibonacciRecursiveDynamic(8));
        System.out.println(f.fibonacciDynamicOptimized(10));
        System.out.println(f.fibAdditiveSequence(8, 0, 1));
    }

}
