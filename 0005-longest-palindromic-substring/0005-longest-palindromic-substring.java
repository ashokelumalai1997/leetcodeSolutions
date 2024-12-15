class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        String res = s.substring(0,1);


        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if(i != 0) {
                dp[i-1][i] = (s.charAt(i) == s.charAt(i-1) ? 1 : 0);
                if(dp[i-1][i] == 1) res = s.substring(i-1,i+1);
                // res = 2;
            }
        }

        

        for(int i = 2; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(dp[j-i+1][j-1] == 1) {
                    dp[j-i][j] = (s.charAt(j-i) == s.charAt(j) ? 1 : 0);
                    if(dp[j-i][j] == 1 && i+1 > res.length())
                        res = s.substring(j-i,j+1);
                }
            }
        }

        return res;

    }
}




//     1   2   3   4   5   6   .... n

// 1   1

// 2       1

// 3           1

// 4

// 5

// 6

// .
// .
// .

// n