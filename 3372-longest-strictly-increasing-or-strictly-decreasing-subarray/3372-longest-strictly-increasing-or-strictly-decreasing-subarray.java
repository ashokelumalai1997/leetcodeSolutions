class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int runningInc = 1;
        int runningDec = 1;

        int n = nums.length;

        int res = 1;

        for(int i = 1; i < n; i++) {
            if(nums[i] > nums[i-1]) {
                runningInc++;
            } else {
                runningInc = 1;
            }

            if(nums[i] < nums[i-1]) {
                runningDec++;
            } else {
                runningDec = 1;
            }

             res = Math.max(res, Math.max(runningInc, runningDec));
        }

        return res;
    }
}