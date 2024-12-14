class Solution {

    private void dfs(char[][] grid, int r, int c, int m, int n) {
        grid[r][c] = '0';


        int[][] pos = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] pp : pos) {

            int p = pp[0];
            int p1 = pp[1];
            // for(int p1 : pos) {
                if(r+p >= 0 && r+p < m && c + p1 >= 0 && c+p1 < n && grid[r+p][c+p1] == '1') {
                    dfs(grid, r+p, c+p1, m,n);
                }
            // }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }

        return count;
    }
}