class Solution {
    private boolean properIsland(int[][] grid1, int[][] grid2, int i, int j) {

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        boolean isProper = true;
        int r = grid2.length;
        int c = grid2[0].length;
        // int count = 0;
        while(!q.isEmpty()) {
            // count++;
            Pair current = q.poll();
            int row = (int)current.getKey();
            int col = (int)current.getValue();
            if(grid2[row][col] != 1) {
                System.out.println(grid2[row][col]);
                continue;
            }
            grid2[row][col] = -1;

            if(grid1[row][col] != 1) isProper = false;
            if(row + 1 < r && (grid2[row + 1][col] == 1)) 
                q.offer(new Pair(row+1, col));
            if(row - 1 >= 0 && (grid2[row - 1][col] == 1)) 
                q.offer(new Pair(row-1, col));
            if(col + 1 < c && (grid2[row][col + 1] == 1)) 
                q.offer(new Pair(row, col+1));
            if(col - 1 >= 0 && (grid2[row][col - 1] == 1)) 
                q.offer(new Pair(row, col-1));
            

        }
        // System.out.println(count);
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