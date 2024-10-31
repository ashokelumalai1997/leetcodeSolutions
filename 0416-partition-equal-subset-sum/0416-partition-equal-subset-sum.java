class Solution {

    private boolean canMakeTarget(int[][] dp, int ind, int target, int[] nums) {
        if(target == 0) return true;

        if(ind == nums.length) return false;

        if(dp[ind][target] != -1) return dp[ind][target] == 1;

        boolean take = false;
        if(nums[ind] <= target) 
            take = canMakeTarget(dp, ind+1, target-nums[ind], nums);
        boolean notTake = canMakeTarget(dp, ind+1, target, nums);
        dp[ind][target] = take || notTake ? 1 : 0;
        return take || notTake;

    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums) total += num;
        if(total%2 != 0) return false;
        int n = nums.length;

        int[][] dp = new int[n][total/2+1];

        for(int i = 0; i < n; i ++) Arrays.fill(dp[i], -1);

        return canMakeTarget(dp, 0, total/2, nums);
    }
}


// find total

// // total/2 is the target . Return if you can find the target


// // f(i, sum) denotes if sum can be formed from ith index
// //     if(sum == 0) return true
// //     if(i == n) return false
// //     a f(i+1, sum)
// //     b f(i+1, sum-nums[i])
// //     return a || b


// // 1 5 11 5

// // f(0, 11)
// //     f(1, 11)
// //         f(2, 11)
// //             f(3, 11)
// //             f(3, 0)
// //         f(2, 6)
        
// //     f(1, 10)
