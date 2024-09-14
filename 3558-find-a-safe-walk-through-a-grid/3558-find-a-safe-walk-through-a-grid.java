import java.util.*;

class Solution {
    class CellDetail implements Comparable<CellDetail>{
        int rID;
        int cID;
        int totalDist;

        public CellDetail(int rowID, int colID, int totalDist) {
            rID = rowID;
            cID = colID;
            this.totalDist = totalDist;
        }

        public int compareTo(CellDetail c) {
            return this.totalDist - c.totalDist;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        // Use a 2D array to store minimum distances
        int[][] minDist = new int[m][n];
        for (int[] row : minDist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minDist[0][0] = grid.get(0).get(0);
        
        PriorityQueue<CellDetail> queue = new PriorityQueue<>();
        queue.offer(new CellDetail(0, 0, grid.get(0).get(0)));
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
        
        while (!queue.isEmpty()) {
            CellDetail cd = queue.poll();
            
            if (cd.rID == m - 1 && cd.cID == n - 1) {
                return health - cd.totalDist > 0;
            }
            
            for (int[] dir : directions) {
                int newRow = cd.rID + dir[0];
                int newCol = cd.cID + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newTotalDist = cd.totalDist + grid.get(newRow).get(newCol);
                    if (newTotalDist < minDist[newRow][newCol]) {
                        minDist[newRow][newCol] = newTotalDist;
                        queue.offer(new CellDetail(newRow, newCol, newTotalDist));
                    }
                }
            }
        }
        
        return false;
    }
}