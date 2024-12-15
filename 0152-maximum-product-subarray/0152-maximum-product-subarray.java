class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;


        int maxPro = Integer.MIN_VALUE;

        for(int i = 0; i < n; i ++) {
            int pro = 1;
            for(int j = i; j < n; j++) {
                pro *= nums[j];
                maxPro = Math.max(maxPro, pro);
            }
        }

        return maxPro;
    }
}