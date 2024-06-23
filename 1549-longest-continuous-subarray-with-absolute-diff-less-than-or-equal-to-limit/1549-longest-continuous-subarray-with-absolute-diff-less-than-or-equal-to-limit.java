class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int minPos = 0;
        int maxPos = 0;
        int n = nums.length;
        int result = 0;
        while(right < n) {
            if(nums[right] < nums[minPos]) minPos = right;
            if(nums[right] > nums[maxPos]) maxPos = right;
            if(nums[maxPos] - nums[minPos] > limit) {
                left = Math.min(minPos, maxPos) + 1;
                minPos = left;
                maxPos = left;
                int temp = left;
                while(temp <= right) {
                    if(nums[temp] < nums[minPos]) minPos = temp;
                    if(nums[temp] > nums[maxPos]) maxPos = temp;
                    temp++;
                }
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;

    }
}