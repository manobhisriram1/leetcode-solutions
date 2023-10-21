class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
       
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (!deque.isEmpty()) {
                dp[i] = Math.max(dp[i], dp[deque.peekFirst()] + nums[i]);
            }
            maxSum = Math.max(maxSum, dp[i]);

            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
        }

        return maxSum;
    }
}