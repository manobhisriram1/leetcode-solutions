class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
         int maxCandies = candies[0];
        
        // Find the maximum number of candies in the given array
        for (int i = 1; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        
        // Determine if each kid can have the greatest number of candies with extra candies
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}