class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        
        while (i < n) {
            if (nums[i] == val) {
                // Replace current element with the last valid one
                nums[i] = nums[n - 1];
                n--; // Reduce the array size
            } else {
                i++; // Move to next if current element is valid
            }
        }
        
        return n; // 'n' is the count of elements not equal to 'val'
    }
}