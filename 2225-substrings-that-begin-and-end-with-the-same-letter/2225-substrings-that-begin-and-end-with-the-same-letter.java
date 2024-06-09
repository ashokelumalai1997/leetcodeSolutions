class Solution {
    public long numberOfSubstrings(String s) {
        long result = 0;
        long[] freq = new long[26];
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
            result+=freq[ch-'a'];
        }
        return result;
    }
}