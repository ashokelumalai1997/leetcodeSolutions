class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0;
        int maxOnes = 0;
        for(int num : nums) {
            if(num == 1) ones++;
            else {
                maxOnes = Math.max(ones, maxOnes);
                ones = 0;
            }
        }
        maxOnes = Math.max(ones, maxOnes);
        return maxOnes;
    }
}