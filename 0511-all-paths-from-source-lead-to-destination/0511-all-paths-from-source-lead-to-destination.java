class Solution {

    private boolean dfsCheck(int[] cache,
            boolean[] visited, int src, 
            int dest, int[] oDegree, 
            Map<Integer, List<Integer>> adjList) {

        // do a dfs from source on all paths, if it leads to null return false

        if(src == dest) {
            return true;
        }

        if(oDegree[src] == 0) return false;

        if(visited[src] == true) return false;

        if(cache[src] != -1) return cache[src] == 1;

        visited[src] = true;

        

        for(int node : adjList.get(src)) {
            if(!dfsCheck(cache, visited, node, dest, oDegree, adjList)) {
                cache[src] = 0;
                return false;
            }
        }

        visited[src] = false;

        cache[src] = 1;

        return true;

        // if(it reaches to des) return true

        // other node with outdegree 0, return false

        // continue dfs
    }
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        int[] oDegree = new int[n];

        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            oDegree[edge[0]]++;
        }

        boolean[] visited = new boolean[n];

        if(oDegree[destination] != 0) return false;
        
        int[] cache = new int[n];

        Arrays.fill(cache, -1);

        return dfsCheck(cache, visited, source, destination, oDegree, adjList);
        
    }
}


        // 1       2           3       4       5
        //     6           7           8       9
        //           10
        //     11


        