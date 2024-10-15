class Solution {

    private boolean canSplit(int[][] dp, int[] nums, int req, int index, int sumSoFar) {
        if(index == nums.length) {
            if(sumSoFar == req) return true;
            return false;
        }

        // if (sumSoFar > req) return false; // Early stopping

        if(dp[index][sumSoFar] != -1) return dp[index][sumSoFar] == 1;
        //canSplit(dp, [1,5,11,5], 11, , 0)
        boolean take = canSplit(dp, nums, req, index+1, sumSoFar+nums[index]);
        //canSplit(dp, [1,5,11,5], 11, 0, 0)
        boolean notTake = canSplit(dp, nums, req, index+1, sumSoFar);
        dp[index][sumSoFar] = (take || notTake) == true ? 1 : 0;
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums) total += num;
        if(total %2 != 0) return false;
        int req = total/2;
        int[][] dp = new int[nums.length][total+1];
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);
        return canSplit(dp ,nums, req, 0, 0); //canSplit(dp, [1,5,11,5], 11, 0, 0)
    }
}



//canSplit(dp, [1,5,11,5], 11, 0, 0)

// f(0,0)
//     f(1,1)
//         f(5,2)
//             f(16,3)
//             f(5,3)
//         f(1,2)
//             f(12, 3)
//             f(1,3)
//     f(1,0)
//         f(2,2)
//             f(14,3)
//             f(2,3)
//         f(2,2)
//             f()

