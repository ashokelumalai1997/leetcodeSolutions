class Solution {

    int time;

    private void fillAllCriticalEdges(int node, int[] low, int[] disc, 
        boolean[] vis, int parent, List<List<Integer>> criticalEdges, 
        List<List<Integer>> adjList) {

            vis[node] = true;
            low[node]  =time;
            disc[node] = time;
            time++;

            for(int child : adjList.get(node)) {

                if(parent == child) continue;
                if(!vis[child]) {
                    fillAllCriticalEdges(child, low, disc, vis, 
                        node, criticalEdges, adjList);
                    low[node] = Math.min(low[child], low[node]);
                    if(low[child] > disc[node]) {
                        // List<Integer> edge = new ArrayList<>();
                        // edge.add(node);
                        // edge.add(child);
                        criticalEdges.add(Arrays.asList(node, child));
                    }
                } else {
                    
                    low[node] = Math.min(low[node], disc[child]);
                }
            }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        List<List<Integer>> criticalEdges = new ArrayList<>();

        boolean[] vis = new boolean[n];
        int[] low = new int[n];
        int[] disc = new int[n];

        time = 1;

        fillAllCriticalEdges(0, low, disc, vis, -1, criticalEdges, adjList);

        return criticalEdges;
    }
}