class Solution {
    public int minIncrementForUnique(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] <= prev) {
                result += prev - nums[i]+1;
                nums[i] = prev+1;
                
            }
            prev = nums[i];
        }
        return result;
    }
}