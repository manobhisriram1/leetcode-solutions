
class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = time.length;
        int [][]dp = new int[n+1][n+1];
        for (int i = 0; i <= n; ++i) 
            for (int j = 0; j <= n; ++j) 
                dp[i][j] = 0x3f3f3f3f;
        dp[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= n; ++j) {
                int t = Math.min(n, j + time[i] + 1);
                dp[i+1][t] = Math.min(dp[i+1][t], dp[i][j] + cost[i]);
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
            }
        }
        return dp[n][n];
    }
}