class Solution {
    public int countDigitOne(int n) {
        int ans = 0;
        for (long pow10 = 1; pow10 <= n; pow10 *= 10) {
            long div = pow10 * 10;
            ans += (n / div) * pow10 + Math.min(Math.max(n % div - pow10 + 1, 0), pow10);
        }
        return ans;
    }
}
