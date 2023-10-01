class Solution {
    public long maximumTripletValue(int[] nums) {
        long res=0;
        long maxAMB =0;
        long maxA=0;
        for(int a:nums){
            res=Math.max(res,maxAMB*a);
            maxAMB=Math.max(maxAMB,maxA-a);
            maxA=Math.max(maxA,a);
        }
        return res;
    }
}