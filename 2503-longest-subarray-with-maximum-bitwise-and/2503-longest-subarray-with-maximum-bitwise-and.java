class Solution {
    public int longestSubarray(int[] nums) {
        int len = 1;
        int maxLen = 1;
        int maxNum = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            if(nums[i] != nums[i-1]){
                if(nums[i-1] == maxNum) maxLen = Math.max(len, maxLen);
                else if(nums[i-1] > maxNum) {
                    maxLen = len;
                    maxNum = nums[i-1];
                }
                len = 1;
            } else {
                len++;
            }
        }
        if(maxNum < nums[n-1]) maxLen = len;
        else if(maxNum == nums[n-1]) maxLen = Math.max(len, maxLen);
        return maxLen;
    }
}