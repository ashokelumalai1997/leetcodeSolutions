class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int totalDays = cells.length;

        int[][] grid = new int[row][col];

        int left = 0;
        int right = totalDays - 1;
        int result = 0;

        while(left <= right) {
            int mid = left + (right - left)/2;
            fillTheGrid(grid, mid, cells, row, col);
            if(passable(grid, row, col)) {
                result = mid+1;
                left = mid+1;
            } else {
                right = mid-1;
            }
            resetTheGrid(grid, row, col);
        }
        return result;
    }

    private void fillTheGrid(int[][] grid, int mid, int[][] cells, int row, int col) {
        for(int i = 0; i <= mid; i++) {
            grid[cells[i][0]-1][cells[i][1]-1] = 1;
        }
    }

    private void resetTheGrid(int[][] grid, int row, int col) {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                grid[i][j] = 0;
            }
        }
    }

    private boolean passable(int[][] grid, int row, int col) {
        Queue<Integer[]> q = new LinkedList<>();

        boolean[][] vis = new boolean[row][col];

        for(int i = 0; i < col; i++) {
            if(grid[0][i] != 0) continue;
            q.offer(new Integer[]{0, i});
            vis[0][i] = true;
        }

        

        while(!q.isEmpty()) {
            Integer[] current = q.poll();
            
            Integer[][] positions = new Integer[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

            for(Integer[] pos : positions) {
                Integer[] nextPos = new Integer[]{current[0]+pos[0], current[1]+pos[1]};
                if(nextPos[0] >= row || nextPos[0] < 0) continue;
                if(nextPos[1] >= col || nextPos[1] < 0) continue;
                if(vis[nextPos[0]][nextPos[1]]) continue;
                if(grid[nextPos[0]][nextPos[1]] != 1) {
                    if(nextPos[0] == row-1) return true;
                    q.offer(nextPos);
                    vis[nextPos[0]][nextPos[1]] = true;
                }
            }

        }

        return false;
    }
}