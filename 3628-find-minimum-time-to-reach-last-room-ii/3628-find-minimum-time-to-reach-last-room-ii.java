class Solution {
	public int minTimeToReach(int[][] moveTime) {
		int m = moveTime.length;
		int n = moveTime[0].length;
		

		// int[] - array of size 3 , 0 - row, 1 - col, 2 - distance
		PriorityQueue<int[]> pq = new PriorityQueue<>(
(a, b) -> a[2] - b[2]
);

		pq.offer(new int[]{0, 0, 0, 0});

		int minDist = 0;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        int[][] moveDist = new int[m][n];

        for(int[] a : moveDist) Arrays.fill(a, Integer.MAX_VALUE);

        // moveDist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			int[] current  = pq.poll();
			
			int row = current[0];
			int col = current[1];
			int dist = current[2];
            int f = current[3];
	
			if(row == m-1 && col == n-1) {
				minDist = dist;
				break;
}

if(dist >= moveDist[row][col]) continue;

moveDist[row][col] = dist;

for(int[] dir : directions) {
	int nextRow = row + dir[0];
	int nextCol = col + dir[1];
	
	if(nextRow < m && nextRow >= 0 
&& nextCol < n && nextCol >= 0) {


    int ddist = 1;

    if(f == 1) ddist = 2;

int nextDist = Math.max(ddist + moveTime[nextRow][nextCol], dist + ddist);



// if(moveDist[nextRow][nextCol] <= nextDist) continue;
pq.offer(new int[]{nextRow, nextCol, nextDist, (f == 1) ? 0 : 1});
// moveDist[nextRow][nextCol] = nextDist;
}
}
}

return minDist;

}
}
