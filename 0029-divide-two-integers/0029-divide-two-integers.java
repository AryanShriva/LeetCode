class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        // Use long to handle the overflow
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        long result = 0;
        
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor, multiple = 1;
            
            // Try to double the divisor to speed up the division
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            
            // Subtract the divisor multiple from the dividend
            absDividend -= tempDivisor;
            result += multiple;
        }
        
        // Return the result with the correct sign
        return negative ? (int) -result : (int) result;
    }
}
