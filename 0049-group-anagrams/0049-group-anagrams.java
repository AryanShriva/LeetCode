import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        for (String s : strs) {
            int[] count = new int[26];
            
            // Count frequencies of each character
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            // Build a unique string signature from the frequency array
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            
            // Group the strings using the signature
            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }
            anagramMap.get(key).add(s);
        }
        
        return new ArrayList<>(anagramMap.values());
    }
}
