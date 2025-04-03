class Solution {
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int pos = -1;
		for(int i = 0; i < n-1; i++) {
			if(nums[i] < nums[i+1]) pos = i;
}

int swapPos = pos+1;

if(pos == -1) {
	reverse(nums, 0);
    return;
}

for(int i = n-1; i >= swapPos; i--) {
	if(nums[i] > nums[pos]) {
		swapPos = i;
		break;
}
}

int temp = nums[pos];
nums[pos] = nums[swapPos];
nums[swapPos] = temp;



reverse(nums, pos+1);
}

public void reverse(int[] nums, int k) {
	int left = k;
	int right = nums.length - 1;
	while(left < right) {
		int temp = nums[left];
nums[left] = nums[right];
nums[right] = temp;
left++;
right--;
}
}
}

