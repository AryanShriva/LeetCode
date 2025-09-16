class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> Result = new HashMap<>();

        int numLength = nums.length;
        for(int i = 0; i< numLength;i++){
            int diff = target - nums[i];

            if(Result.containsKey(diff)){
                return new int[] {i, Result.get(diff)};
            }

            Result.put(nums[i],i);
        }
        return null;
    }
}