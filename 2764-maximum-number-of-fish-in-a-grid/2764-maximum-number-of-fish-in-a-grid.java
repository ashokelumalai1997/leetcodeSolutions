class Solution {

    private int dfs(int[][] grid, int i, int j) {
        
        int fishes = grid[i][j];
        
        grid[i][j] = 0;

        int m = grid.length;

        int n = grid[0].length;


        if(i+1 < m && grid[i+1][j] > 0) {
            fishes += dfs(grid, i+1, j);
        }

        if(j+1 < n && grid[i][j+1] > 0) {
            fishes += dfs(grid, i, j+1);
        }

        if(i-1 >= 0 && grid[i-1][j] > 0) {
            fishes += dfs(grid, i-1, j);
        }

        if(j-1 >= 0 && grid[i][j-1] > 0) {
            fishes += dfs(grid, i, j-1);
        }

        return fishes;
    }
    public int findMaxFish(int[][] grid) {
        int fishes = 0;


        int m = grid.length;

        int n = grid[0].length;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] > 0) {
                    fishes = Math.max(fishes, dfs(grid, i, j));
                }
            }
        }


        return fishes;
    }
}