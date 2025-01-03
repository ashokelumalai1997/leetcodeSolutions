class Solution {
    public int waysToSplitArray(int[] nums) {
        long total = 0;

        for(int num : nums) total += num;

        int count = 0;

        long runningSum = 0;

        int n = nums.length;

        for(int i = 0; i < n-1; i++) {
            runningSum += nums[i];
            if(runningSum >= (total - runningSum)) count++;
        }

        return count;
    }
}