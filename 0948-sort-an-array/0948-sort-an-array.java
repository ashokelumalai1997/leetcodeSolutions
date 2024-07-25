class Solution {
    private int[] sort(int[] nums, int left, int right){
        if(left == right) return new int[]{nums[left]};
        if(left == right - 1) {
            int[] numsO = new int[2];
            numsO[0] = nums[left];
            numsO[1] = nums[right];
            if(nums[left] > nums[right]) {
                numsO[0] = nums[right];
                numsO[1] = nums[left];
            }
            return numsO;
        }
        int mid = left + (right - left)/2;
        int[] nums1 = sort(nums, left, mid);
        int[] nums2 = sort(nums, mid+1, right);
        return reorder(nums1, nums2);
    }
    private int[] reorder(int[] nums1, int[] nums2){
        int start = 0;
        int end = nums1.length + nums2.length - 1;
        int leftP = 0;
        int right = nums1.length -1;
        int right1 = nums2.length - 1;
        int rightP = 0;
        int[] numsO = new int[end+1];
        while(leftP <= right && rightP <= right1) {
            if(nums1[leftP] > nums2[rightP]) {
                numsO[start] = nums2[rightP];
                rightP++;
            } else {
                numsO[start] = nums1[leftP];
                leftP++;
            }
            start++;
        }
        while(leftP <= right) {
            numsO[start] = nums1[leftP];
            leftP++;
            start++;
        }
        while(rightP <= right1) {
            numsO[start] = nums2[rightP];
            rightP++;
            start++;
        }
        return numsO;
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        
        return sort(nums, left, right);
    }
}