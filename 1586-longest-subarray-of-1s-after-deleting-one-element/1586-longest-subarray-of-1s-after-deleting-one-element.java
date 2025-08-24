class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int left = 0;

        int right = 0;

        int res = 0;

        int zerosSoFar = 0;

        while(right < n) {
            if(nums[right] == 0) {
                zerosSoFar++;
            }

            while(left < right && zerosSoFar > 1) {
                if(nums[left] == 0) {
                    zerosSoFar--;
                }
                left++;
            }

            int current = right - left + 1;

            if(zerosSoFar == 1 || right - left + 1 == n) {
                current--;
            }

            res = Math.max(res, current);

            right++;
        }

        return res;
    }
}