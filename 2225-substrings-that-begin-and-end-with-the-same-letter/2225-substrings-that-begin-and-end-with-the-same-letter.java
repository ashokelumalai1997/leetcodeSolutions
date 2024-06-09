class Solution {
    public long numberOfSubstrings(String s) {
        long result = 0;
        long[] freq = new long[26];
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }
        for(int i = 0; i < 26; i ++) {
            result += freq[i]*(freq[i]+1)/2;
        }
        return result;
    }
}