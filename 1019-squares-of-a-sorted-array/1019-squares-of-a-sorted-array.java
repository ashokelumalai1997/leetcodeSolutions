class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int pos = n-1;

        int[] res = new int[n];
        while(pos >= 0) {
            int current = 0;
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                current = nums[left]*nums[left];
                left++;
            } else {
                current = nums[right]*nums[right];
                right--;
            }
            res[pos] = current;
            pos--;
        }
        return res;
    }
}