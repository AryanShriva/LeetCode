class Solution {
    public int maxValue(int[] nums, int k) {
        int n = nums.length;
        int maxBit = 0;
        for (int num : nums) maxBit = Math.max(maxBit, num);
        int m = 1;
        while (m <= maxBit) m <<= 1;

        boolean[][][] left = new boolean[n + 1][k + 1][m];
        left[0][0][0] = true;

        // DP for first k elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int or = 0; or < m; or++) {
                    if (left[i][j][or]) {
                        left[i + 1][j][or] = true;
                        if (j + 1 <= k) {
                            left[i + 1][j + 1][or | nums[i]] = true;
                        }
                    }
                }
            }
        }

        boolean[][][] right = new boolean[n + 1][k + 1][m];
        right[n][0][0] = true;

        // DP for last k elements (reverse order)
        for (int i = n; i > 0; i--) {
            for (int j = 0; j <= k; j++) {
                for (int or = 0; or < m; or++) {
                    if (right[i][j][or]) {
                        right[i - 1][j][or] = true;
                        if (j + 1 <= k)
                            right[i - 1][j + 1][or | nums[i - 1]] = true;
                    }
                }
            }
        }

        int ans = 0;
        // Find split point and maximize XOR
        for (int i = k; i <= n - k; i++) {
            for (int x = 0; x < m; x++) {
                if (!left[i][k][x]) continue;
                for (int y = 0; y < m; y++) {
                    if (right[i][k][y]) {
                        ans = Math.max(ans, x ^ y);
                    }
                }
            }
        }
        return ans;
    }
}
