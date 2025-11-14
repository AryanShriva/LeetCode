import java.util.Arrays;

class Solution {
    public int[] findPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) return new int[] {0};

        long INF = Long.MAX_VALUE / 4;
        int full = (1 << n) - 1;

        int[] bestPerm = null;
        long bestCost = INF;

        // For each possible starting node s, compute DP and get lexicographically smallest
        // permutation starting from s with minimal cost.
        for (int s = 0; s < n; s++) {
            long[][] dp = new long[1 << n][n];
            for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], INF);

            // Base: when mask == full, cost to close cycle from last -> s
            for (int last = 0; last < n; last++) {
                dp[full][last] = Math.abs(last - nums[s]);
            }

            // Fill dp for masks decreasing (so dp[mask|1<<next] used is already computed).
            for (int mask = full - 1; mask >= 0; mask--) {
                for (int last = 0; last < n; last++) {
                    if (((mask >> last) & 1) == 0) continue; // last must be in mask
                    long best = INF;
                    // try next not in mask
                    for (int next = 0; next < n; next++) {
                        if (((mask >> next) & 1) == 1) continue;
                        int nmask = mask | (1 << next);
                        long cand = Math.abs(last - nums[next]) + dp[nmask][next];
                        if (cand < best) best = cand;
                    }
                    // If mask already full this loop won't run (we set base earlier).
                    // For masks that already had all nodes (shouldn't reach here), keep INF.
                    if (best != INF) dp[mask][last] = best;
                }
            }

            // total minimal cost when starting at s is dp[1<<s][s]
            long total = dp[1 << s][s];
            if (total == INF) continue; // should not happen for valid inputs

            // If this start's cost is worse than current best, skip reconstruction.
            if (total > bestCost) continue;

            // Reconstruct lexicographically smallest permutation for this (s) using dp table.
            int[] perm = new int[n];
            int idx = 0;
            int mask = 1 << s;
            int last = s;
            perm[idx++] = s;

            for (int step = 1; step < n; step++) {
                // choose smallest next that satisfies dp[mask][last] == |last - nums[next]| + dp[mask|1<<next][next]
                boolean chosen = false;
                for (int next = 0; next < n; next++) {
                    if (((mask >> next) & 1) == 1) continue;
                    int nmask = mask | (1 << next);
                    long need = Math.abs(last - nums[next]) + dp[nmask][next];
                    if (need == dp[mask][last]) {
                        perm[idx++] = next;
                        mask = nmask;
                        last = next;
                        chosen = true;
                        break; // picking smallest next ensures lexicographic minimality
                    }
                }
                if (!chosen) {
                    // Shouldn't happen; defensive
                    break;
                }
            }

            // Compare / choose best (min cost, then lexicographically smallest)
            if (total < bestCost) {
                bestCost = total;
                bestPerm = perm;
            } else if (total == bestCost) {
                if (bestPerm == null || lexicographicallySmaller(perm, bestPerm)) {
                    bestPerm = perm;
                }
            }
        }

        // Convert bestPerm to int[] (should always be non-null for valid inputs)
        if (bestPerm == null) {
            // fallback: identity permutation
            bestPerm = new int[n];
            for (int i = 0; i < n; i++) bestPerm[i] = i;
        }
        return bestPerm;
    }

    private boolean lexicographicallySmaller(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) return true;
            if (a[i] > b[i]) return false;
        }
        return false; // equal
    }
}
