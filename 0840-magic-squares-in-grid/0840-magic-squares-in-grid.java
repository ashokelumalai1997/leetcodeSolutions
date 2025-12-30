class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for(int i = 0; i < rows - 2; i++) {
            for(int j = 0; j < cols - 2; j++) {
                if(goodGrid(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }


    private boolean goodGrid(int[][] grid, int i, int j) {
        boolean[] seen = new boolean[10];
        for(int ii = 0; ii < 3; ii++) {
            for(int jj = 0; jj < 3; jj++) {
                if(grid[i+ii][j+jj] > 9 || grid[i+ii][j+jj] < 1) return false;
                int num = grid[i+ii][j+jj];
                if(seen[num]) return false;
                seen[num] = true;
            }
        }

        int rSum1 = grid[i][j] + grid[i][j+1] + grid[i][j+2];
        int rSum2 = grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2];
        int rSum3 = grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];

        int cSum1 = grid[i][j] + grid[i+1][j] + grid[i+2][j];
        int cSum2 = grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1];
        int cSum3 = grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2];

        int dSum1 = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
        int dSum2 = grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];

        if(rSum1 != rSum2) return false;
        if(rSum2 != rSum3) return false;
        if(rSum3 != cSum1) return false;

        if(cSum2 != cSum1) return false;
        if(cSum2 != cSum3) return false;

        if(cSum2 != dSum1) return false;
        if(cSum2 != dSum2) return false;

        return true;
    }
}