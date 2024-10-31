class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sf = new int[26];
        if(s.length() != t.length()) return false;
        for(char ch : s.toCharArray()) {
            sf[ch-'a']++;
        }

        for(char ch : t.toCharArray()) {
            sf[ch-'a']--;
        }

        for(int num : sf) {
            if(num != 0) return false;
        }

        return true;
    }
}