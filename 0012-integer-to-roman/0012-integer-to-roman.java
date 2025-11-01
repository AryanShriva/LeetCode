class Solution {
    public String intToRoman(int num) {
        // Define an array of values and their corresponding Roman numeral symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();
        
        // Process the number starting from the largest value
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]); // Add the Roman symbol
                num -= values[i]; // Subtract the value
            }
        }
        
        return roman.toString(); // Return the final Roman numeral string
    }
}
