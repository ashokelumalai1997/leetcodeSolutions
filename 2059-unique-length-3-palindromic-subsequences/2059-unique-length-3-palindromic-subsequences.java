class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] prefixCounter = new int[n][26];
        int[][] suffixCounter = new int[n][26];

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            prefixCounter[i][c - 'a']++;

            if(i-1 < 0) continue;

            for(int j = 0; j < 26; j++) {
                prefixCounter[i][j] += prefixCounter[i-1][j];
            }
        }

        for(int i = n-1; i >=0 ; i--) {
            char c = s.charAt(i);
            suffixCounter[i][c - 'a']++;

            if(i+1 > n-1) continue;

            for(int j = 0; j < 26; j++) {
                suffixCounter[i][j] += suffixCounter[i+1][j];
            }
        }

        int[][] flag = new int[26][26];


        int count = 0;


        for(int i = 0; i < n; i++) {
            if(i+1 > n-1 || i-1 < 0) continue;
            char ch = s.charAt(i);
            for(int j = 0; j < 26; j++) {
                if(prefixCounter[i-1][j] != 0 
                        && suffixCounter[i+1][j] != 0
                        && flag[ch - 'a'][j] == 0) {
                    flag[ch - 'a'][j] = 1;
                    count++;
                    
                }
            }
        }


        return count;


    }
}