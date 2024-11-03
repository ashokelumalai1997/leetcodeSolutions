class Solution {
    public int minTimeToReach(int[][] moveTime) {

        // int temp = moveTime[0][0];
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++) Arrays.fill(res[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq 
                = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {
            int[] currentNode = pq.poll();

            int row = currentNode[0];
            int col = currentNode[1];
            int dist = currentNode[2];

            if(row+1 < m) {
                if(1+dist < res[row+1][col]) {
                res[row+1][col] = Math.max(1+moveTime[row+1][col], Math.min(res[row+1][col], 1+dist));
                pq.offer(new int[]{row+1, col, res[row+1][col]});
                }
            }
            

            if(col+1 < n) {
                if(1+dist < res[row][col+1]) {
                res[row][col+1] = Math.max(1+moveTime[row][col+1], Math.min(res[row][col+1], 1+dist));
                pq.offer(new int[]{row, col+1, res[row][col+1]});
                }
            }

            if(row-1 >= 0) {
                if(1+dist < res[row-1][col]) {
                res[row-1][col] = Math.max(1+moveTime[row-1][col], Math.min(res[row-1][col], 1+dist));
                pq.offer(new int[]{row-1, col, res[row-1][col]});
                }
            }
            

            if(col-1 >= 0) {
                if(1+dist < res[row][col-1]) {
                    res[row][col-1] = Math.max(1+moveTime[row][col-1], Math.min(res[row][col-1], 1+dist));
                    pq.offer(new int[]{row, col-1, res[row][col-1]});
                }
            }
        }

        return res[m-1][n-1];

        
    }
}


    // 1.   2.  3.  4
    // 5.   6.  7.  8
    // 9.  10. 11. 12