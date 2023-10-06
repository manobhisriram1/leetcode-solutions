class Solution {
    public String gcdOfStrings(String str1, String str2) {
  
   for (int i = Math.min(str1.length(), str2.length()); i > 0; i--) {
            String candidate = str1.substring(0, i);
            if (isDivisor(candidate, str1) && isDivisor(candidate, str2)) {
                return candidate;
            }
        }
        return "";
    }

    private static boolean isDivisor(String candidate, String str) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < str.length()) {
            sb.append(candidate);
        }
        return sb.toString().equals(str);
    }
}