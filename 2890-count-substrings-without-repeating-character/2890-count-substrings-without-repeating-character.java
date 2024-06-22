class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int start = 0;
        int result = 0;
        int[] charPositionMap = new int[26];
        Arrays.fill(charPositionMap, -1);
        for(int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if(charPositionMap[ch - 'a'] != -1 && start <= charPositionMap[ch - 'a']) {
                start = charPositionMap[ch - 'a'] + 1;
            }
            charPositionMap[ch - 'a'] = i;
            result += (i - start + 1);
        }
        return result;
    }
}