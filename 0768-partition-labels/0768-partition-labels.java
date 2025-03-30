class Solution {
	public List<Integer> partitionLabels(String s) {
		// traverse from left to right
		// update map of last occurence of individual chars
		// keep track of start of current substring, max last occurence
		// whenever max last occur meets current ind, update start, calc current subs len and add it result

		List<Integer> result = new ArrayList<>();
		
		Map<Character, Integer> lastOccurence = new HashMap<>();
		
		int n = s.length();
		
		for(int i = 0; i < n; i++) {
			lastOccurence.put(s.charAt(i), i);
}

int start = 0;
int maxLastOccur = 0;



for(int i = 0; i < n; i++) {
	int lastOccur = lastOccurence.get(s.charAt(i));
	maxLastOccur = Math.max(lastOccur, maxLastOccur);
	if(maxLastOccur == i) {
		int len = i - start + 1;
		result.add(len);
		start = i+1;
		maxLastOccur = i+1;
}
}

return result;
}
}
