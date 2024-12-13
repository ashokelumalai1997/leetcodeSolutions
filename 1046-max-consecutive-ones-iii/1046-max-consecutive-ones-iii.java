class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;


        int z = 0;

        int res = 0;

        while(right < n) {
            if(nums[right] == 0) z++;
            while(z > k && left <= right) {
                z -= (nums[left] == 1 ? 0 : 1);
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}