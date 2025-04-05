class Solution {
	boolean search(int[] nums, int target) {
int n = nums.length;
int left = 0;
int right = n-1;

while(left <= right) {
	int mid = left + (right - left)/2;
	if(target == nums[mid]) return true;
        if(nums[left] == nums[right] && nums[mid] == nums[right]) {
            left++;
            right--;
            continue;
        }
	if(nums[mid] >= nums[left])  {
		if(target >= nums[left] && target < nums[mid]) right = mid-1;
		else left = mid+1;
} else {
	if(target > nums[mid] && target <= nums[right]) left = mid+1;
	else right = mid-1;
}
}

return false;
}
}