class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim leading/trailing spaces
        s = s.trim();
        
        // Step 2: Split by one or more spaces
        String[] words = s.split("\\s+");
        
        // Step 3: Reverse the words
        Collections.reverse(Arrays.asList(words));
        
        // Step 4: Join with a single space
        return String.join(" ", words);
    }
}
