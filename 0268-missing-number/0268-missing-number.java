//using sum method (n*(n+1))/2
// class Solution {
//         public int missingNumber(int[] nums) {
//                 int n = nums.length;
//                 int expectedSum = n * (n + 1) / 2;
//                 int actualSum = 0;

//                 for (int num : nums) {
//                     actualSum += num;
//                 }

//                 return expectedSum - actualSum;
//         }
// }


//using xor
class Solution {
    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }
}




