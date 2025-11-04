class Solution {
    public long countOfSubstrings(String word, int k) {
        // exactly k consonants = atLeast(k) - atLeast(k+1)
        return countAtLeastKConsonants(word, k) - countAtLeastKConsonants(word, k + 1);
    }
    
    private long countAtLeastKConsonants(String word, int k) {
        int n = word.length();
        long result = 0L;
        
        int left = 0;
        int consonantCount = 0;
        // track counts of vowels a,e,i,o,u
        int[] vowelFreq = new int[5];
        int distinctVowels = 0;
        
        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            if (isVowel(c)) {
                int idx = vowelIndex(c);
                if (vowelFreq[idx] == 0) {
                    distinctVowels++;
                }
                vowelFreq[idx]++;
            } else {
                consonantCount++;
            }
            
            // Shrink from left while the window is valid (distinctVowels==5 and consonantCount >= k)
            while (left <= right && distinctVowels == 5 && consonantCount >= k) {
                // When window [left..right] has all vowels and at least k consonants,
                // then all substrings that start from any index <= left and end at right are valid.
                // That means (left + 1) valid substrings end at right (if left indexing 0).
                result += (n - right);
                
                // Now move left pointer to shrink window
                char lc = word.charAt(left);
                if (isVowel(lc)) {
                    int idx2 = vowelIndex(lc);
                    vowelFreq[idx2]--;
                    if (vowelFreq[idx2] == 0) {
                        distinctVowels--;
                    }
                } else {
                    consonantCount--;
                }
                left++;
            }
        }
        
        return result;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    private int vowelIndex(char c) {
        switch(c) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
        }
        return -1;
    }
}
