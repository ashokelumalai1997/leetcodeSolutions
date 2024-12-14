class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int right = 0;
        int left = 0;

        int n = nums.length;

        int count = 0;


        int prod = 1;

        while(right < n) {
            prod *= nums[right];

            while(left <= right && prod >= k) {
                prod /= nums[left];
                left++;
            }

            count += (right - left + 1);
            right++;
        }


        return count;
    }
}