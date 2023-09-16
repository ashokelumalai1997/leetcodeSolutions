class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int res = -1;
        int mid;
        while(low<=high){
            mid=(low+high)/2;
            //System.out.println("Low "+low+" high "+high + " mid "+mid);
            if(nums[mid]==target)
            {
                res=mid;
                break;
            }
            if(nums[low]<=nums[mid]){
                if(target<nums[mid]&&target>=nums[low]){
                    high=mid-1;
                    //continue;
                } else {
                    low=mid+1;
                    //continue;
                }
                
            } else {
                if(target>nums[mid]&&target<=nums[high]){
                    low=mid+1;
                    //continue;
                } else {
                    high=mid-1;
                    //continue;
                }
            }
        }
        return res;
    }
}