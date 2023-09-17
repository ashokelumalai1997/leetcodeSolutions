class Solution {
    public int search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        int mid=(low+high)/2;
        while(low<=high){
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) low=mid+1;
            else high=mid-1;
            mid=(low+high)/2;
        }
        return -1;
    }
}