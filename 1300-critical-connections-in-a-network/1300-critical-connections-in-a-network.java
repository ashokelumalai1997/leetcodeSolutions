// if child is parent , skip
// if child is visited , update low of current with disc of child
// do dfs of child
// update low of node with node of child
// if low of child > disc of current node, add it to bridges


class Solution {

    private void findBridges(int node, int[] low, int[] disc, int parent, 
                        boolean[] vis, int[] time, List<List<Integer>> adj, 
                            List<List<Integer>> bridges) {
        if(vis[node]) return;

        vis[node] = true;

        low[node] = time[0];
        disc[node] = time[0];

        time[0] ++ ;

        for(int child : adj.get(node)) {
            if(child == parent) continue;
            if(!vis[child]) {
                findBridges(child, low, disc, node, vis, time, adj, bridges);
                low[node] = Math.min(low[child], low[node]);
                if(low[child] > disc[node]) {
                    bridges.add(Arrays.asList(node, child));
                }
            } else {
                low[node] = Math.min(disc[child], low[node]);
            }
            
        }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] time = {1};
        int parent = -1;
        boolean[] vis = new boolean[n];
        int[] low = new int[n];
        int[] disc = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> edge :  connections) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        findBridges(0, low, disc, parent, vis, time, adj, bridges);
        return bridges;
    }
}





//         1 d/l
//         2 d/l
//         3 d/l
//     4       5 d/l
//         6



// // 1,2
// 2,3


