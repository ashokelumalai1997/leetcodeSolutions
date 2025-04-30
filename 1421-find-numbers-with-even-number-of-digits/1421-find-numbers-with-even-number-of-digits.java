class Solution {
	public int findNumbers(int[] nums) {
		int count = 0;
		for(int num : nums) {
			if(isEvenDigit(num)) count++;
}

return count;
}

private boolean isEvenDigit(int num) {
	// if(num == 0) return false;
	int digits = 0;
	while(num > 0) {
		digits++;
		num /= 10;
}
return digits%2 == 0;
}
}
