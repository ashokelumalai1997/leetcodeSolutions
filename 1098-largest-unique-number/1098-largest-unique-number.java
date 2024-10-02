class Solution {
    public int largestUniqueNumber(int[] nums) {
        int res = -1;
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 1) return nums[0];
        for(int i = 0; i < n; i++) {
            if(i == n-1 || nums[i+1] != nums[i]) res = nums[i];
            while(i+1 != n && nums[i+1] == nums[i]) i++;
        }
        return res;
    }
}