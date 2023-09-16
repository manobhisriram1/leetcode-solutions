class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0; // Initialize the maximum profit to 0
    
    for (int i = 1; i < prices.length; i++) {
        // Calculate the profit if we sell on the current day (prices[i])
        int profit = prices[i] - prices[i - 1];
        
        // If the profit is positive, add it to the maxProfit
        if (profit > 0) {
            maxProfit += profit;
        }
    }
    
    return maxProfit;
}
    }
