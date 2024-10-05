class Solution {
    private boolean compare(int[] s1Freq, int[][] s2Freq, int n1, int endIndex) {
        int indexToSubtract = endIndex - n1;
        if(indexToSubtract < -1) return false;
        if(indexToSubtract == -1) {
            for(int i = 0; i < 26; i++) {
                if(s1Freq[i] != s2Freq[endIndex][i]) return false;
            }
            return true;
        }

        for(int i = 0; i < 26; i ++) {
            if(s2Freq[endIndex][i] - s2Freq[indexToSubtract][i] != s1Freq[i]) return false;
        }

        return true;

    }
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Freq = new int[26];
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] s2Freq = new int[n2][26];
        for(int i = 0; i < n1; i++) {
            char currentChar = s1.charAt(i);
            s1Freq[currentChar - 'a']++;
        }
        // s2Freq[0][s2.charAt(0) - 'a']++;
        // if(compare(s1Freq, s2Freq, n1, 0)) return true;
        for(int i = 0; i < n2; i++) {
            if(i!=0) {
                for(int j = 0; j < 26; j++) {
                    s2Freq[i][j] = s2Freq[i-1][j];
                }
            }
            s2Freq[i][s2.charAt(i) - 'a']++;
            
            if(compare(s1Freq, s2Freq, n1, i)) return true;
        }
        return false;
    }
}