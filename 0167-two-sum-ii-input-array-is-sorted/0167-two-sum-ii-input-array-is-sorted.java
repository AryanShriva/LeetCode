class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // return 1-based indices
                return new int[]{left + 1, right + 1};
            } 
            else if (sum < target) {
                left++;   // move left pointer to increase sum
            } 
            else {
                right--;  // move right pointer to decrease sum
            }
        }

        return new int[]{-1, -1}; // fallback (though problem guarantees solution)
    }
}
