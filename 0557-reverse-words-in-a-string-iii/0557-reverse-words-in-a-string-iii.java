
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");  // Split the input string into words
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();  // Reverse each word
            reversedString.append(reversedWord).append(" ");  // Append the reversed word to the result
        }

        return reversedString.toString().trim();  // Trim to remove the trailing space and return the result
    }
}