class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] zTracker = new int[n];

        zTracker[0] = (s.charAt(0) == '0') ? 1 : 0;

        for(int i = 1; i < n; i++) {
            zTracker[i] = zTracker[i-1] + ((s.charAt(i) == '0') ? 1 : 0);
        }

        int ones = (s.charAt(n-1) == '1') ? 1 : 0;

        int maxScore = 0;

        int score = 0;

        for(int i = n-2; i >= 0; i--) {
            score = ones + zTracker[i];
            maxScore = Math.max(score, maxScore);
            ones += (s.charAt(i) == '1') ? 1 : 0;
        }

        return maxScore;
    }
}