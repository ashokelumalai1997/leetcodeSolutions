class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        // 0 - unvisited
        // 1 - blue
        // -1 - red

        int[] flag = new int[n];
        
        

        for(int k = 0; k < n; k++) {
            if(flag[k] != 0) continue;
            Queue<Integer> q = new LinkedList<>();

            flag[k] = 1;

        q.offer(k);

        while(!q.isEmpty()) {
            int current = q.poll();

            int currentColor = flag[current];
            int nextColor = flag[current]*-1;

            int nextN = graph[current].length;

            for(int i = 0; i < nextN; i++) {
                int nextNode = graph[current][i];
                if(flag[nextNode] == 0) {
                    flag[nextNode] = nextColor;
                    q.offer(nextNode);
                }
                else if(flag[nextNode] == currentColor) return false;
            }
         }
        }
        

        
        return true;
    }
}