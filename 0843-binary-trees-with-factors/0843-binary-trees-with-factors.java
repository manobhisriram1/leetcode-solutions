class Solution {
     private static final int MOD = 1000000007;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long[] dp = new long[arr.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0) {
                    int rightFactor = arr[i] / arr[j];
                    int index = Arrays.binarySearch(arr, rightFactor);
                    if (index >= 0) {
                        dp[i] = (dp[i] + dp[j] * dp[index]) % MOD;
                    }
                }
            }
        }

        long total = 0;
        for (long num : dp) {
            total = (total + num) % MOD;
        }

        return (int) total; 
    }
}