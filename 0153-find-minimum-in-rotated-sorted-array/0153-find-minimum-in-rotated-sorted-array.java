class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;


        while(left <= right) {
            int mid = left + (right - left)/2;

            if(nums[left] <= nums[right]) return nums[left];
            if(nums[mid] >= nums[left]) left = mid+1;
            else if(mid - 1 >= 0 && nums[mid-1] > nums[mid]) return nums[mid];
            else right = mid-1;
        }

        return -1;
    }
}