class Solution {
    public int longestPalindrome(String s) {
        int[] lowerCaseTracker = new int[26];
        int[] upperCaseTracker = new int[26];
        for(char ch : s.toCharArray()) {
            if(ch >= 'a') {
                upperCaseTracker[ch - 'a']++;
            } else {
                lowerCaseTracker[ch - 'A']++;
            }
        }
        int result = 0;
        int isThereOdd = 0;
        for(int i = 0; i < 26; i ++) {
            result += lowerCaseTracker[i] + upperCaseTracker[i];
            if(lowerCaseTracker[i]%2 != 0) {
                result -= 1;
                isThereOdd = 1;
            }
            if(upperCaseTracker[i]%2 != 0) {
                result -= 1;
                isThereOdd = 1;
            }
        }
        return result + isThereOdd;
    }
}