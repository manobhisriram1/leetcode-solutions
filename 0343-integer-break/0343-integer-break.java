class Solution {
    public int integerBreak(int n) {
       
         if (n <= 3) {
            // If n is 2 or 3, the maximum product is n - 1
            return n - 1;
        }

        int result = 1;
        while (n > 4) {
            // Break the number into as many 3s as possible
            result *= 3;
            n -= 3;
        }
        // Multiply the remaining number (which is less than or equal to 4) to the result
        result *= n;
        
        return result;
    }
}