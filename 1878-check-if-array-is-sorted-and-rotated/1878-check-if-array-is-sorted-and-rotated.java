class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int count = 0;

        for(int i = 1; i < n; i++) {
            if(nums[i-1] > nums[i]) count++;
        }

        if(nums[n-1] > nums[0]) count++;

        return count <= 1;
    }
}



// a a+1 a+3 a+3 . .... a+10


// 10 12 13 13 1 2 15