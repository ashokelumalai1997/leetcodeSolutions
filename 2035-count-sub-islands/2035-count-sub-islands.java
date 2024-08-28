class Solution {
    private boolean properIsland(int[][] grid1, int[][] grid2, int i, int j) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        boolean isProper = true;
        int r = grid2.length;
        int c = grid2[0].length;
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            if(grid2[row][col] != 1) continue;
            grid2[row][col] = 0;
            if(grid1[row][col] != 1) isProper = false;
            if(row + 1 < r) 
                q.offer(new int[]{row+1, col});
            if(row - 1 >= 0) 
                q.offer(new int[]{row-1, col});
            if(col + 1 < c) 
                q.offer(new int[]{row, col+1});
            if(col - 1 >= 0) 
                q.offer(new int[]{row, col-1});
            

        }
        return isProper;

    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;
        int r = grid2.length;
        int c = grid2[0].length;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid2[i][j] == 1) {
                    if(properIsland(grid1, grid2, i, j)) result++;
                }
            }
        }
        return result;
    }
}