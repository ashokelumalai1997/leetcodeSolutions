class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[left] < nums[right]) return nums[left]; // Already sorted
            if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid + 1; // ensure left moves forward
            }
        }

        return nums[left]; // or nums[right], both same at this point
    }
}
