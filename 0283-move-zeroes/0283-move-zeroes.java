class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int numPointer = 0;
        int i = 0;
        while(i < n) {
            if(nums[i] != 0) {
                int temp = nums[numPointer];
                nums[numPointer] = nums[i];
                nums[i] = temp;
                numPointer++;
            }
            i++;
        }
        
    }
}