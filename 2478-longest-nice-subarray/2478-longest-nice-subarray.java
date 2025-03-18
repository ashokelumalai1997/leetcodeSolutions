


class Solution {
	
	public int longestNiceSubarray(int[] nums) {
		int n = nums.length;
		int left = 0;
		int right = 0;
		int[] bitVector = new int[32];
        int maxLen = 0;
		while(right < n) {
			int current = nums[right];
updateVector(current, bitVector);		
while( left < right && !isGood(bitVector) ) {
	decrementVector(nums[left], bitVector);
	left++;
}
maxLen = Math.max(maxLen, right - left + 1);
right++;
}
return maxLen;
}

private boolean isGood(int[] vector) {
for(int num : vector) {
	if(num > 1) return false;
}
return true;
}

private void updateVector(int num, int[] vector) {
int bitPos = 0;
while(bitPos < 32) {
	int andRes = ((1 << bitPos) & num);
	vector[bitPos] += (andRes > 0) ? 1 : 0;
	bitPos++;
}
}

private void decrementVector(int num, int[] vector) {
int bitPos = 0;
while(bitPos < 32) {
	int andRes = ((1 << bitPos) & num);
	vector[bitPos] -= (andRes > 0) ? 1 : 0;
	bitPos++;
}
}
}
