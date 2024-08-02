class Solution {
    public int minSwaps(int[] nums) {
        int minimumZeros = Integer.MAX_VALUE;
        int n = nums.length;
        int totalOnes = 0;
        for(int i = 0; i < n; i++) {
            totalOnes += nums[i];
        }
        int left = 0;
        int right = 0;
        int totalZeros = 0;
        while(left < n) { //left < n
            if(left <= n - totalOnes) {
                while(right < n && right - left < totalOnes) { 
                    totalZeros += (nums[right] == 0 ? 1 : 0);
                    right++;
                }
            } else {
                right %= n;
                int diff = n - left + right;
                while(diff < totalOnes) {
                    totalZeros += (nums[right] == 0 ? 1 : 0);
                    right++;
                    diff = n - left + right + 1;
                }
            }
            minimumZeros = Math.min(minimumZeros, totalZeros);
            totalZeros -= (nums[left] == 0 ? 1 : 0);
            left++;
        }
        return minimumZeros;
    }
}