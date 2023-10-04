package main.java.dp;


import java.util.Arrays;

// https://www.youtube.com/watch?v=oaloiuvGcQg
public class ZeroOneKnapsack {

    // https://www.youtube.com/watch?v=mGfK-j9gAQA
    int knapsackRec(int[] weights, int[] values, int capacity, int n) {

        if (capacity == 0 || n == 0) {
            return 0;
        }

        if (weights[n - 1] > capacity) {
            return knapsackRec(weights, values, capacity, n - 1);
        }

        // weights[n - 1] <= capacity
        var include = values[n - 1] + knapsackRec(weights, values, capacity - weights[n - 1], n - 1);
        var exclude = knapsackRec(weights, values, capacity, n - 1);

        return Math.max(include, exclude);
    }

    // https://www.youtube.com/watch?v=dT6dvdbpChA
    int knapsackMemo(int[] values, int[] weights, int capacity, int n) {

        var memo = new int[n + 1][capacity + 1];

        for (var row : memo) {
            Arrays.fill(row, -1);
        }

        return knapsackMemoHelper(values, weights, capacity, n, memo);
    }

    private int knapsackMemoHelper(int[] weights, int[] values, int capacity, int n, int[][] memo) {

        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (memo[n][capacity] != -1) {
            return memo[n][capacity];
        }

        if (weights[n - 1] > capacity) {
            memo[n][capacity] = knapsackMemoHelper(weights, values, capacity, n - 1, memo);
            return memo[n][capacity];
        }

        var include = values[n - 1] + knapsackMemoHelper(weights, values, capacity - weights[n - 1], n - 1, memo);
        var exclude = knapsackMemoHelper(weights, values, capacity, n - 1, memo);
        memo[n][capacity] = Math.max(include, exclude);

        return memo[n][capacity];
    }

    // https://www.youtube.com/watch?v=WNkqbqyvR_0
    int knapsackDp(int[] weights, int[] values, int capacity, int n) {

        var dp = new int[n + 1][capacity + 1];

        for (var i = 0; i <= n; i++) {
            for (var w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // weights[n - 1] <= capacity
                    var include = values[i - 1] + dp[i - 1][w - weights[i - 1]];
                    var exclude = dp[i - 1][w];
                    dp[i][w] = Math.max(include, exclude);
                }
            }
        }

        return dp[n][capacity];
    }

    int knapsackDpOpt(int[] weights, int[] values, int capacity, int n) {

        var dp = new int[capacity + 1];

        for (var i = 0; i < n; i++) {
            for (var w = capacity; w >= weights[i]; w--) {
                dp[w] = Math.max(values[i] + dp[w - weights[i]], dp[w]);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {

        var weights1 = new int[]{3, 2, 6, 4};
        var values1 = new int[]{5, 6, 3, 2};
        var capacity1 = 8; // 11
        var n1 = weights1.length;

        var values2 = new int[]{60, 100, 120};
        var weights2 = new int[]{10, 20, 30};
        var capacity2 = 50; // 220
        var n2 = weights2.length;

        var ks = new ZeroOneKnapsack();
        System.out.println(ks.knapsackRec(weights1, values1, capacity1, n1));
        System.out.println(ks.knapsackMemo(weights1, values1, capacity1, n1));
        System.out.println(ks.knapsackDp(weights1, values1, capacity1, n1));
        System.out.println(ks.knapsackDpOpt(weights1, values1, capacity1, n1));

        System.out.println(ks.knapsackRec(weights2, values2, capacity2, n2));
        System.out.println(ks.knapsackMemo(weights2, values2, capacity2, n2));
        System.out.println(ks.knapsackDp(weights2, values2, capacity2, n2));
        System.out.println(ks.knapsackDpOpt(weights2, values2, capacity2, n2));
    }

}
