class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posPos = 0;
        int negPos = 0;
        int i = 0;
        while(nums[i] >= 0) {
            // posPos = i;
            i++;
        }
        negPos = i;

        i = 0;
        while(nums[i] < 0) {
            // posPos = i;
            i++;
        }

        posPos = i;

        int n= nums.length;

        int[] res = new int[n];

        for( i = 0; i < nums.length; i++) {
            res[i++] = nums[posPos];
            posPos++;
            res[i] = nums[negPos];
            negPos++;
            while(posPos < n && nums[posPos] < 0) {
                posPos++;
            }

            while(negPos < n && nums[negPos] >= 0) {
                negPos++;
            }
        }

        return res;


    }
}