class Solution {
    public int maximumLength(int[] nums, int k) {
       int[][] dp = new int[nums.length + 1][k + 1];
        for (int[] row : dp) {
            // for (int[] row : rows) {
                Arrays.fill(row, -1);
            // }
        }
        return f(0,nums,-1,k ,dp);
    }
    
    static int f(int idx , int nums[] ,int prev , int k , int dp[][]){
        if(idx>=nums.length) return 0;
        if(dp[prev+1][k]!=-1)return dp[prev+1][k];
        int take = 0;
        int nottake =f(idx+1,nums,prev,k,dp);

        
        if(prev==-1 || (nums[idx]==nums[prev])){
            take = 1 + f(idx+1,nums,idx,k,dp);
        }
        else  if(prev==-1 || k>0) {
            take += 1+ f(idx+1,nums,idx,k-1,dp); 
        }
         
    
        int res = Math.max(take, nottake);
        dp[prev+1][k] = res;
        return res;
        
        
    }
}