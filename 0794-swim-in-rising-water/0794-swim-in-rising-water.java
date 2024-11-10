class Solution {

    static class QEntry implements Comparable<QEntry> {
        int nodeX;
        int nodeY;
        int maxSoFar;

        public QEntry(int x, int y, int time) {
            this.nodeX = x;
            this.nodeY = y;
            this.maxSoFar = time;
        }

        public int compareTo(QEntry qe) {
            return this.maxSoFar - qe.maxSoFar;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];

        PriorityQueue<QEntry> pq = new PriorityQueue<>((a,b) -> a.maxSoFar - b.maxSoFar);

        pq.offer(new QEntry(0,0,grid[0][0]));

        int[][] dirs = new int[][] {
            // {-1, -1},
            {-1, 0},
            // {-1, 1},
            // {1, -1},
            {1, 0},
            // {1, 1},
            {0, 1},
            {0, -1}
        };

        int result = grid[0][0];

        while(!pq.isEmpty()) {
            QEntry current = pq.poll();

            int currentNodeX = current.nodeX;
            int currentNodeY = current.nodeY;
            int currentTime = grid[currentNodeX][currentNodeY];
            vis[currentNodeX][currentNodeY] = true;

            

            if(currentNodeX == n-1 && currentNodeY == n-1) {
                result = current.maxSoFar;
                break;
            }

            for(int[] dir : dirs) {
                int newX = dir[0] + currentNodeX;
                int newY = dir[1] + currentNodeY;
                
                if(newX < n && newY < n && newX >= 0 && newY >= 0) {
                    if(vis[newX][newY]) continue;
                    // int timeNeeded = grid[newX][newY] - currentTime;
                    // if(timeNeeded < 0) timeNeeded = 0;

                    int msf = Math.max(current.maxSoFar, grid[newX][newY]);

                    pq.offer(new QEntry(newX, newY, msf));
                }
            }
        }

        return result;
    }
}


// [10,12,4,6]
// [9,11,3,5]
// [1,7,13,8]
// [2,0,15,14]

// push 0,0 into the q

// see neighbourse in all directions and if the time we can reach there
// skip visited neighbours


// keep track of max of visiting nodes whenever we pull one from queue


// return max
