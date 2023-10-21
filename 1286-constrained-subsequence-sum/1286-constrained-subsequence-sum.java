class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=nums[i];
        }
        LinkedList<Integer> mQ = new LinkedList<>();
        mQ.offer(nums.length-1);
        for(int i=nums.length-2;i>=0;i--){
            while(!mQ.isEmpty()&&mQ.getFirst()>i+k){
                mQ.removeFirst();
            }
            int now = nums[i]+dp[mQ.getFirst()];
            dp[i]=Math.max(now,dp[i]);
            while(!mQ.isEmpty()&&dp[mQ.getLast()]<dp[i]){
                mQ.removeLast();
            }
            mQ.offer(i);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}