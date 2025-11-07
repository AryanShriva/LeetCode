import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            // Remove all nodes strictly between u and v
            Integer next = set.higher(u);
            while (next != null && next < v) {
                set.remove(next);
                next = set.higher(u);
            }

            ans[i] = set.size() - 1; // shortest path length = nodes - 1
        }

        return ans;
    }
}
