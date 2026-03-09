import java.util.*;

public class Experiment_5 {

    public static int subset(int[] arr, int s, int n) {

        if (s == 0) {
            return 1;
        }

        if (n == 0 || s < 0) {
            return 0;
        }

        int include = subset(arr, s - arr[n - 1], n - 1);
        int exclude = subset(arr, s, n - 1);

        return include + exclude;
    }

    public static int subset2(int[] arr, int s, int n, int[][] dp) {

        if (s == 0) {
            return 1;
        }

        if (n == 0 || s < 0) {
            return 0;
        }

        if (dp[n][s] != -1) {
            return dp[n][s];
        }

        int include = subset2(arr, s - arr[n - 1], n - 1, dp);
        int exclude = subset2(arr, s, n - 1, dp);

        return dp[n][s] = include + exclude;
    }

    public static int subset3(int[] arr, int s) {

        int n = arr.length;

        int[][] dp = new int[n + 1][s + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {

            int curr = arr[i - 1];

            for (int j = 1; j <= s; j++) {

                int exclude = dp[i - 1][j];

                int include = 0;

                if (curr <= j) {
                    include = dp[i - 1][j - curr];
                }

                dp[i][j] = exclude + include;
            }
        }

        return dp[n][s];
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int sum = 5;

        int n = arr.length;

        int[][] dp = new int[n + 1][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(subset(arr, sum, n));
        System.out.println(subset2(arr, sum, n, dp));
        System.out.println(subset3(arr, sum));
    }
}


// time complexity -- > brute force -- o(2^n) ---> using dp o(n*sum)