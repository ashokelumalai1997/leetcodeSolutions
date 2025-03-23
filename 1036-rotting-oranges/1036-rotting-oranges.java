// Easyy peasyy lemon squeazyy
class Solution {
    class Trio{
        int r;
        int c;
        int t;
        public Trio(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Trio> q = new LinkedList<>();
        int[][] dirs = new int[][] {{1 ,0 } , {-1 , 0} , {0 , 1} , {0 , -1}};
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0, time = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new Trio(i, j, 0));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        while(!q.isEmpty()){
            Trio curr = q.poll();
            int r = curr.r, c = curr.c, t = curr.t;
            time = t;
            for(int i = 0; i < 4; i++){
                int nextR = r + dirs[i][0];
                int nextC = c + dirs[i][1];
                if(nextR >= 0 && nextC >= 0 && nextR < m && nextC < n && grid[nextR][nextC] == 1){
                    fresh--;
                    grid[nextR][nextC] = 2;
                    q.add(new Trio(nextR, nextC, time+1));
                }
            }
        }
        return fresh == 0 ? time : -1;
    }
}