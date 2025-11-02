class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n; i++) {
            if(nums[i] < 0) nums[i]*=-1;
        }
        Arrays.sort(nums);
        return (long)nums[n-2]*nums[n-1]*100000;
    }
}