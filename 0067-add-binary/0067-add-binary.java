class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;

        // Loop through both strings from the last character to the first
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            // Add the current digit of 'a' if available
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to int
                i--;
            }

            // Add the current digit of 'b' if available
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to int
                j--;
            }

            // The result for this digit is sum % 2 (either 0 or 1)
            result.append(sum % 2);

            // The carry for the next iteration is sum / 2 (either 0 or 1)
            carry = sum / 2;
        }

        // Reverse the result to match the correct order
        return result.reverse().toString();
    }
}
