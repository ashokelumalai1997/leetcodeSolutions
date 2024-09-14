class Solution {
    public int longestSubarray(int[] nums) {
        int currentNum = 0;
        int currentLen = 0;
        int maxLen = 0;
        for(int num : nums) {
            if(num < currentNum) {
                currentLen = 0;
            }
            if(num > currentNum) {
                currentNum = num;
                currentLen = 1;
                maxLen = 0;
            } else if(num == currentNum) {
                currentLen++;
            }
            maxLen = Math.max(currentLen, maxLen);
        }
        return maxLen;
    }
}