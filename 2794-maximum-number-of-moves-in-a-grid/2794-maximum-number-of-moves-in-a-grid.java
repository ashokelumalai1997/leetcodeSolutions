class Solution {
    private int getMoves(int[][] dp, int row, int col, int[][] grid) {
        if(grid.length <= row || grid[0].length <= col) {
            return 0;
        }

        if(dp[row][col] != -1) return dp[row][col];

        int moves = 0;
        if(row-1 >= 0 && col+1 < grid[0].length 
            && grid[row-1][col+1] > grid[row][col]) {
                moves = Math.max(moves, 1+getMoves(dp, row-1, col+1, grid));
        }

        if( col+1 < grid[0].length 
            && grid[row][col+1] > grid[row][col]) {
                moves = Math.max(moves, 1+getMoves(dp, row, col+1, grid));
        }

        if(row+1 < grid.length && col+1 < grid[0].length 
            && grid[row+1][col+1] > grid[row][col]) {
                moves = Math.max(moves, 1+getMoves(dp, row+1, col+1, grid));
        }

        return dp[row][col] = moves;

    }
    public int maxMoves(int[][] grid) {
        int maxMoves = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        for(int i = 0; i < m; i ++) {
            maxMoves = Math.max(maxMoves, getMoves(dp, i, 0, grid));
        }

        return maxMoves;
    }
}