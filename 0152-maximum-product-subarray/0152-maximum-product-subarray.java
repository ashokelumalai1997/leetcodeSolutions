class Solution {
    public int maxProduct(int[] nums) {
        int maxVal = 1;
        int minVal = 1;

        int res = Integer.MIN_VALUE;
        for(int num : nums) {
            int temp = maxVal;
            maxVal = Math.max(num, Math.max(maxVal*num, minVal*num));
            minVal = Math.min(num, Math.min(temp*num, minVal*num));
            res = Math.max(maxVal, res);
        }

        return res;
    }
}