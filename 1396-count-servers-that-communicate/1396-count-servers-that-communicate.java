class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        int[] rowWise = new int[m];
        int[] colWise = new int[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                rowWise[i]++;
                colWise[j]++;
            }
        }

        int servers = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                if(rowWise[i] > 1 || colWise[j] > 1) servers++;
            }
        }

        return servers;
    }
}