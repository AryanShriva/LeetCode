class Solution {
    public String largestOddNumber(String num) {
        // Traverse from the end of the string
        for (int i = num.length() - 1; i >= 0; i--) {
            // Check if the current character is an odd number
            if ((num.charAt(i) - '0') % 2 != 0) {
                // Return substring from start to this index
                return num.substring(0, i + 1);
            }
        }
        // If no odd digit found, return empty string
        return "";
    }
}
