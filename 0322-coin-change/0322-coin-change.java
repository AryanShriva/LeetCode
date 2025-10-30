class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        
        // Initialize DP array with a large number
        Arrays.fill(dp, max);
        dp[0] = 0; // Base case — 0 coins to make amount 0

        // For each coin, compute minimum coins needed for each amount
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] not updated, return -1 (impossible)
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
