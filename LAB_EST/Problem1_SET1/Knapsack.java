package LAB_EST.Problem1_SET1;

class Knapsack {

    public static void main(String[] args) {

        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int W = 4;

        int n = val.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {

                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        val[i - 1] + dp[i - 1][w - wt[i - 1]]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Max Value = " + dp[n][W]);
    }
}