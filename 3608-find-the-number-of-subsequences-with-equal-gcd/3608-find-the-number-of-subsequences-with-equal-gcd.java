class Solution {
    private int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b%a, a);
    }

    private int getMax(int index, int[][][] dp, int gcd1, int gcd2, int[] nums)
    {
        if(index == dp.length) {
            if(gcd1 != 0 && gcd2 == gcd1) return 1;
            return 0;
        }

        if(dp[index][gcd1][gcd2] != -1) return dp[index][gcd1][gcd2];

        int gcd1n = (gcd1 == 0) ? nums[index] : gcd(gcd1, nums[index]);
        int gcd2n = (gcd2 == 0) ? nums[index] : gcd(gcd2, nums[index]);
        int temp = 0;
        temp += getMax(index+1, dp, gcd1n, gcd2, nums);
        temp %= 1000000007;
        temp += getMax(index+1, dp, gcd1, gcd2n, nums);
        temp %= 1000000007;
        temp += getMax(index+1, dp, gcd1, gcd2, nums);
        temp %= 1000000007;
        return dp[index][gcd1][gcd2] = temp;
    }
    public int subsequencePairCount(int[] nums) {
        int max = 0;
        for(int num : nums) max = Math.max(max, num);
        int n = nums.length;
        int[][][] dp = new int[n][max+1][max+1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < (max + 1); j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getMax(0, dp, 0, 0, nums);
    }
}