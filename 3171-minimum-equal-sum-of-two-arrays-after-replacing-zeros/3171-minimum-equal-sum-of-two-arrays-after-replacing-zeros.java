class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int count1=0;
        int count2=0;
        long sum1=0;
        long sum2=0;
        for(int i = 0;i<nums1.length;i++){
            if(nums1[i]==0) count1++;
            sum1+=nums1[i];
        }
        for(int i = 0;i<nums2.length;i++){
            if(nums2[i]==0) count2++;
            sum2+=nums2[i];
        }
        if(count1==0&&count2==0&&sum1!=sum2) return -1;
        if(count1==0){
            if(count2+sum2>sum1) return -1;
        }
        if(count2==0){
            if(count1+sum1>sum2) return -1;
        }
        return Math.max(sum1+count1,sum2+count2);
    }
}