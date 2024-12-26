class Solution {
    private int addSubNoth(int[][] dp, int id, int n, int[] nums, int target) {
        if(n == id) {
            if(target == 0) return 1;
            return 0;
        }

        if(dp[id][target+1000] != -1) return dp[id][target+1000];

        int add = addSubNoth(dp, id+1, n, nums, target - nums[id]);
        int sub = addSubNoth(dp, id+1, n, nums, target + nums[id]);
        // int noth = addSubNoth(id+1, n, nums, target);

        return dp[id][target+1000] = add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][21000+1];
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);
        return addSubNoth(dp, 0, nums.length, nums, target);
    }
}