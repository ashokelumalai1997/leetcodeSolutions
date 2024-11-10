class Solution {

    static class QEntry {
        int col;
        int node;
        public QEntry(int node, int color) {
            this.node = node;
            col = color;
        }
    }
    public boolean isBipartite(int[][] graph) {
        Queue<QEntry> q = new LinkedList<>();

        int n = graph.length;
        int[] color = new int[n];

        boolean[] vis = new boolean[n];

        for(int i = 0; i <n; i++) {

            if(color[i] != 0) continue;

        q.offer(new QEntry(i, -1));
        vis[i] = true;
        

        color[i] = -1;

        while(!q.isEmpty()) {
            QEntry qe = q.poll();
            int node = qe.node;
            int col = qe.col;

            int neededColor  = (col == -1) ? 1 : -1;

            for(int child : graph[node]) {
                if(vis[child] && color[child] == col) return false;
                if(vis[child]) continue;
                q.add(new QEntry(child, neededColor));
                color[child] = neededColor;
                vis[child] = true;
            }
        }
        }

        return true;
    }
}