class Solution {
    public int romanToInt(String s) {
        // Create a map for Roman numeral symbols and their corresponding integer values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int result = 0;
        
        // Iterate over the string and process each character
        for (int i = 0; i < s.length(); i++) {
            // Get the value of the current Roman numeral character
            int currentVal = romanMap.get(s.charAt(i));
            
            // If we're not at the last character, check if the current value is smaller than the next one
            if (i + 1 < s.length()) {
                int nextVal = romanMap.get(s.charAt(i + 1));
                // If the current value is smaller, subtract it from the result
                if (currentVal < nextVal) {
                    result -= currentVal;
                } else {
                    result += currentVal;
                }
            } else {
                result += currentVal; // Last character, just add it
            }
        }
        
        return result;
    }
}
