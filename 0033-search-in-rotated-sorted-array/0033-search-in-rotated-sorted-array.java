class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Found target
            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // search left
                } else {
                    left = mid + 1;  // search right
                }
            } 
            // Otherwise, right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // search right
                } else {
                    right = mid - 1; // search left
                }
            }
        }
        return -1; // not found
    }
}
