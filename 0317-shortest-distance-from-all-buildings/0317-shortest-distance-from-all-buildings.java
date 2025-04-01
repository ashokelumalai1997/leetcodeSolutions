class Solution {

	public int bfs(int[][] grid, int r, int c, int target) {
		int m = grid.length;
		int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

Queue<int[]> bfsQueue  = new LinkedList<>();

int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

bfsQueue.offer(new int[]{r, c, 0});

vis[r][c] = true;

int distance = 0;

int houses = 0;


while(!bfsQueue.isEmpty()) {
	int[] current  = bfsQueue.poll();
	
	int row = current[0];
	int col = current[1];
	int dist = current[2];

	if(grid[row][col] == 1) { 
distance += dist; 
houses++;
continue;
}
	
	for(int[] dir : dirs) {
		int newr = dir[0] + row;
		int newc = dir[1] + col;
		if(newr < m && newc < n && newr >= 0 && newc >= 0) {
			if(grid[newr][newc] != 2 && !vis[newr][newc] ) {
				bfsQueue.offer(new int[]{newr, newc, dist+1});
                vis[newr][newc] = true;
}
}
}
}

return (houses == target) ? distance : Integer.MAX_VALUE;		
		
}
	public int shortestDistance(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int minDis = Integer.MAX_VALUE;

		int target = 0;

for(int i = 0; i< m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					target++;
}
}
}
		
		for(int i = 0; i< m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 0) {
					minDis = Math.min(minDis, bfs(grid, i, j, target));
}
}
}


return minDis == Integer.MAX_VALUE  ? -1 : minDis;
}
}
