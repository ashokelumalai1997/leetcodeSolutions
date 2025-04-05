class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int n = nums.length;

        int right = n-1;

        int res = nums[0];

        while(left <= right) {
            int mid = left + (right - left)/2;

            

            if(nums[left] <= nums[mid]) {
                res = Math.min(res, nums[left]);
                left = mid+1;
            } else {
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            }

        }

        return res;
    }
}