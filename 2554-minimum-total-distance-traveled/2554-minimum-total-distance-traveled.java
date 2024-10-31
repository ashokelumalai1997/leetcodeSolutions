class Solution {
    private long stopOrGo(long[][][] dp, int rInd, int fInd, List<Integer> robot, int[][] factory) {
        if(rInd == robot.size()) return 0;

        if(fInd == factory.length) return Long.MAX_VALUE; 

        if(dp[rInd][fInd][factory[fInd][1]] != -1) return dp[rInd][fInd][factory[fInd][1]];

        long stop = Long.MAX_VALUE;

        if(factory[fInd][1] != 0) {
            factory[fInd][1]--;
            stop = stopOrGo(dp, rInd+1, fInd, robot, factory);
            
            factory[fInd][1]++;
            if(stop != Long.MAX_VALUE) {
                stop = stop + Math.abs(factory[fInd][0] - robot.get(rInd));
            }
        }

        long go = stopOrGo(dp, rInd, fInd+1, robot, factory);

        return dp[rInd][fInd][factory[fInd][1]] = Math.min(go, stop);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Arrays.sort(factory, (a,b) -> a[0] - b[0]);
        Collections.sort(robot);
        int r = robot.size();
        int f = factory.length;
        long dp[][][] = new long[r][f][r+1];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < f; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return stopOrGo(dp, 0,0,robot, factory);
    }
}

// check all possiblities of each robot being part of each of the factories

// f(i,j) - robot i being part of factory j
//     if j is beyond factory list - it needs infinite distance
//     can stop only if there is capacity at current factory
//     can go to next no matter what

//     return min(stop here, go next)