class Solution {
    boolean isPrefixAndSuffix(String str1, String str2) {
        if(str1.length() > str2.length()) return false;

        int n = str2.length();

        int s1Pointer = 0;

        int s1Length = str1.length();

        int left = 0;
        int right = n-str1.length();

        while(s1Pointer < s1Length) {
            if(str2.charAt(left) != str1.charAt(s1Pointer) 
                || str2.charAt(right) != str1.charAt(s1Pointer)) return false;
            left++;
            right++;
            s1Pointer++;
        }
        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(isPrefixAndSuffix(words[i], words[j])) result++;
            }
        }
        return result;
    }
}