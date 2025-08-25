public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        // If the array is not rotated at all
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        
        // Binary search to find the minimum element
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If middle element is greater than right element, the minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {  // If middle element is smaller, the minimum is in the left half
                right = mid;
            }
        }
        
        return nums[left];
    }
}
