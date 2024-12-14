class Solution {

    // private void dfs(char[][] grid, int r, int c, int m, int n) {
    //     grid[r][c] = '0';


    //     int[][] pos = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    //     for(int[] pp : pos) {

    //         int p = pp[0];
    //         int p1 = pp[1];
    //         // for(int p1 : pos) {
    //             if(r+p >= 0 && r+p < m && c + p1 >= 0 && c+p1 < n && grid[r+p][c+p1] == '1') {
    //                 dfs(grid, r+p, c+p1, m,n);
    //             }
    //         // }
    //     }
    // }

    static class Position {

        int row;

        int col;


        public Position(int r, int c) {
            this.row = r;
            this.col = c;
        }

    }

    private void bfs(char[][] grid, int r, int c, int m, int n) {


        Queue<Position> q = new LinkedList<>();


        int[][] positions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };


        q.offer(new Position(r, c));

        grid[r][c] = '0';




        while(!q.isEmpty()) {

            Position qe = q.poll();
            int row = qe.row;
            int col = qe.col;


            

            for(int[] pos : positions) {
                if(row + pos[0] >= 0 
                    && row + pos[0] < m
                    && col + pos[1] >= 0
                    && col + pos[1] < n
                    && grid[row + pos[0]][col + pos[1]] == '1') {
                    grid[row + pos[0]][col + pos[1]] = '0';
                    q.offer(new Position(row + pos[0], col + pos[1]));
                }
            }
        }


    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j, m, n);
                    count++;
                }
            }
        }

        return count;
    }
}