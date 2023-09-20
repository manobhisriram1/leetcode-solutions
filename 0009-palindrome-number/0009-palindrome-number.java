class Solution {
    public boolean isPalindrome(int x) {
           long number = x;
        long reversed = 0;
        
        while (x > 0) {
            int digit = x % 10;
            reversed = (reversed * 10) + digit;
            x /= 10;
        }
        return number == reversed;
          
    }
}