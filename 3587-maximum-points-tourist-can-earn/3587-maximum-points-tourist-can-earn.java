class Solution {
    private int goOrStay(int[][] dp, int day, int currentCity, int n, int k, int[][] stayScore, int[][] travelScore) {
        if(day == k) return 0;
        if(dp[day][currentCity] != -1) return dp[day][currentCity];
        int stay = stayScore[day][currentCity] + goOrStay(dp, day+1, currentCity, n, k, stayScore, travelScore);

        int go = 0;

        for(int i = 0; i < n; i++) {
            go = Math.max(go, travelScore[currentCity][i] + goOrStay(dp, day+1, i, n, k, stayScore, travelScore));
        }

        return dp[day][currentCity] = Math.max(go, stay);
    }

    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int result = 0;
        int[][] dp = new int[k][n];
        for(int i = 0; i < k ; i++) Arrays.fill(dp[i], -1);
        for(int i = 0; i < n; i++) result = Math.max(result, goOrStay(dp, 0, i, n, k, stayScore, travelScore));
        return result;
    }
}

// for a day, currentCity
//     stay
//     goToCity
//         try each city one by one
//     return max of these two


