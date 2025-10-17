import java.util.*;

class Solution {
    // Memoization map: key is [index, bitmask of current partition, canChange flag]
    private Map<List<Integer>, Integer> memo = new HashMap<>();
    private String s;
    private int k;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        return dfs(0, 0, 1);
    }

    /**
     * @param index     - current position in string
     * @param mask      - bitmask representing distinct characters in current partition
     * @param canChange - flag indicating if a change is available (1 = yes, 0 = no)
     * @return maximum partitions from current state
     */
    private int dfs(int index, int mask, int canChange) {
        if (index == s.length()) return 1; // end of string

        // Memoization key
        List<Integer> key = List.of(index, mask, canChange);
        if (memo.containsKey(key)) return memo.get(key);

        int letterBit = 1 << (s.charAt(index) - 'a');
        int newMask = mask | letterBit;

        int maxPartitions;
        // Not changing character
        if (Integer.bitCount(newMask) > k) {
            // Too many distinct chars, need new partition
            maxPartitions = dfs(index + 1, letterBit, canChange) + 1;
        } else {
            // Continue in current partition
            maxPartitions = dfs(index + 1, newMask, canChange);
        }

        // Try changing this character, if available
        if (canChange > 0) {
            for (int c = 0; c < 26; ++c) {
                int changedMask = mask | (1 << c);
                if (Integer.bitCount(changedMask) > k) {
                    maxPartitions = Math.max(maxPartitions,
                            dfs(index + 1, 1 << c, 0) + 1);
                } else {
                    maxPartitions = Math.max(maxPartitions,
                            dfs(index + 1, changedMask, 0));
                }
            }
        }

        memo.put(key, maxPartitions);
        return maxPartitions;
    }
}
