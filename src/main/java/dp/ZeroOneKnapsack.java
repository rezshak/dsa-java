package main.java.dp;


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
    int knapsackMemo(int[] weights, int[] values, int capacity, int n) {
        var memo = new int[n + 1][capacity + 1];
        for (var i = 0; i <= n; i++) {
            for (var j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (weights[i - 1] > j) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    // weights[n - 1] <= capacity
                    var include = values[i - 1] + memo[i - 1][j - weights[i - 1]];
                    var exclude = memo[i - 1][j];
                    memo[i][j] = Math.max(include, exclude);
                }
            }
        }
        return memo[n][capacity];
    }

    // https://www.youtube.com/watch?v=WNkqbqyvR_0
    int knapsackDp(int[] weights, int[] values, int capacity, int n) {
        var dp = new int[n + 1][capacity + 1];
        for (var i = 0; i <= n; i++) {
            for (var j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // weights[n - 1] <= capacity
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }
        return dp[n][capacity];
    }

    int knapsackDpOpt(int[] weights, int[] values, int capacity, int n) {
        var dp = new int[capacity + 1];
        for (var i = 0; i < n; i++) {
            for (var j = capacity; j >= weights[i]; j--) {
                dp[j] = Math.max(values[i] + dp[j - weights[i]], dp[j]);
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {

        var weights1 = new int[] { 3, 2, 6, 4 };
        var values1 = new int[] { 5, 6, 3, 2 };
        var capacity1 = 8; // 11
        var n1 = weights1.length;

        var values2 = new int[] { 60, 100, 120 };
        var weights2 = new int[] { 10, 20, 30 };
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
