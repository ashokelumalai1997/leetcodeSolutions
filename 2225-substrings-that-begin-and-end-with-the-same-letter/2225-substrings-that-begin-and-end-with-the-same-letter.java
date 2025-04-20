class Solution {
	public long numberOfSubstrings(String s) {
		int[] freq = new int[26];
		long count = 0;
		for(char ch : s.toCharArray()) {
			freq[ch - 'a']++;
			count += freq[ch - 'a'];
}

return count;
} 
}
