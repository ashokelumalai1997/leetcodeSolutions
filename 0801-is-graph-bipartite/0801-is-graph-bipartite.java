class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];      // 0 - red, 1- blue, -1 - unassgnd

        Arrays.fill(colors, -1);

        for(int i = 0; i < n; i ++) {
            if(colors[i] != -1) continue;
            Queue<Integer> q = new LinkedList<>();
            colors[i] = 0;
            q.offer(i);
            while(!q.isEmpty()) {
                int node = q.poll();
                int currentColor = colors[node];
                for(int child : graph[node]) {
                    if(colors[child] == colors[node]) return false;
                    if(colors[child] == -1) {
                        colors[child] = currentColor == 1 ? 0 : 1;
                        q.offer(child);
                    }
                }
            }
        }

        return true;
    }
}


// do a bfs from all the nodes

// if child node is already assigned a color, and its same as current, return false

// if child is not assigned a color
// assign a different color to the child nodes, add it to the queue