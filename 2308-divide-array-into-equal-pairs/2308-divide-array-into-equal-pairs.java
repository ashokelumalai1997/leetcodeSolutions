class Solution {
	public boolean divideArray(int[] nums) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for(int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
}

for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {	
	if(entry.getValue() % 2 != 0) return false;
}

return true;
}
}
