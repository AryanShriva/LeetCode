class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap only if i != lastNonZeroIndex to avoid unnecessary swaps
                if (i != lastNonZeroIndex) {
                    int temp = nums[i];
                    nums[i] = nums[lastNonZeroIndex];
                    nums[lastNonZeroIndex] = temp;
                }
                lastNonZeroIndex++;
            }
        }
    }
}
