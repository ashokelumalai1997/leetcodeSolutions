class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};

        int n = nums.length;

        for(int i = 0; i < n; i ++) {
            if(nums[i] == target) {
                if(range[0] == -1) range[0] = i;
                range[1] = i;
            }
        }

        return range;
    }
}