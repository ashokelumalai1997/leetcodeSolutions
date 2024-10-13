class Solution {
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n-1;
        for(int i = 0; i < n-1; i++) {
            if(nums[i] < nums[i+1]) left = i;
        }
        for(int i = n-1; i > left; i--) {
            if(nums[i] > nums[left]) {
                right = i;
                break;
            }
        }
        if(nums[right] > nums[left]) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            reverse(nums, left+1, n-1);
        } else {
            reverse(nums, 0, n-1);
        }


    }
}



// 2 4 5 2 3 1


// 5 4 3 2 1




