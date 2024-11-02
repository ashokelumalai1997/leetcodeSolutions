class Solution {
    public boolean check(int[] nums) {
        int streakBreaks = 0;

        int n = nums.length;

        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[i-1]) streakBreaks++;
        }
        if(streakBreaks == 0) return true;

        if(streakBreaks == 1 && nums[n-1] <= nums[0]) return true;

        return false;

        // return streakBreaks <= 1;

    }
}