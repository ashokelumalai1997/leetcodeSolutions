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
            while(right - left < totalOnes) { 
                    totalZeros += (nums[right%n] == 0 ? 1 : 0);
                    right++;
            }
            minimumZeros = Math.min(minimumZeros, totalZeros);
            totalZeros -= (nums[left] == 0 ? 1 : 0);
            left++;
        }
        return minimumZeros;
    }
}