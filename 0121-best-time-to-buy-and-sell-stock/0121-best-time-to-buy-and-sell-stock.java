class Solution {
    public int maxProfit(int[] prices) {
         if (prices == null || prices.length <= 1) {
        return 0;
    }

    int maxProfit = 0;       // Initialize the maximum profit to 0
    int minPrice = prices[0]; // Initialize the minimum price to the price of the first day

    for (int i = 1; i < prices.length; i++) {
        int currentPrice = prices[i]; // Get the price of the current day

        // Check if the current price is lower than the minimum price seen so far
        if (currentPrice < minPrice) {
            minPrice = currentPrice; // Update the minimum price
        } else {
            // Calculate the profit if we sell at the current price
            int currentProfit = currentPrice - minPrice;

            // Update the maximum profit if the current profit is higher
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
    }

    return maxProfit; // Return the maximum profit
}
        
    }
