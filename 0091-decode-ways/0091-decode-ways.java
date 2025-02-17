class Solution {

    private int decodeWays(int[] memo, String s, int ind) {
        if(ind == s.length()) return 1;

        if(s.charAt(ind) == '0') return 0;

        if(memo[ind] != -1) return memo[ind];

        int ans1 = decodeWays(memo, s, ind+1);

        int ans2 = 0;

        if(ind < s.length()-1 && Integer.valueOf(s.substring(ind, ind+2)) <= 26) {
            ans2 = decodeWays(memo, s, ind+2);
        }

        return memo[ind] = ans1 + ans2;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decodeWays(dp, s, 0);
    }
}