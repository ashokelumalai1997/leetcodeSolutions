class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int originalColor = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        int m = image.length;
        int n = image[0].length;
        image[sr][sc] = color;
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            image[r][c] = color;
            for(int[] dir : directions) {
                if(r + dir[0] < m && r+ dir[0] >= 0
                    && c +dir[1] < n && c + dir[1] >= 0) {
                if(image[r+dir[0]][c+dir[1]] == originalColor) {
                    // image[r+dir[0]][c+dir[1]] = color;
                    q.offer(new int[]{r+dir[0], c+dir[1]});
                }
                    }
            }
        }

        return image;
    }
}