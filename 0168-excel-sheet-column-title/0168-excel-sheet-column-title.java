
public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        // Convert the number to Excel column title
        while (columnNumber > 0) {
            // Adjusting to 1-based indexing (A=1, B=2, ..., Z=26)
            columnNumber--; 
            
            // Get the remainder after dividing by 26
            int remainder = columnNumber % 26;
            
            // Convert the remainder to a character and append it to the result
            char digit = (char) ('A' + remainder);
            result.append(digit);
            
            // Update the number by dividing it by 26 (integer division)
            columnNumber /= 26;
        }
        
        // Reverse the result string to get the final Excel column title
        return result.reverse().toString();
    }
}
