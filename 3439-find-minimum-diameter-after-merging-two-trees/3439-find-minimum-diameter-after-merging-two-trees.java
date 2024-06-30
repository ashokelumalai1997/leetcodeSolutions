class Solution {
    
    private int bfsGetLastNode(int start, Map<Integer, List<Integer>> adjList){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int lastNode = 0;
        int[] visited = new int[adjList.size()];
        while(!q.isEmpty()) {
            lastNode = q.poll();
            visited[lastNode] = 1;
            for(int node : adjList.get(lastNode)) {
                if(visited[node] == 0)
                    q.offer(node);
            }
        }
        return lastNode;
    }

    private int getHeightOfTree(int node, Map<Integer, List<Integer>> adjList, int[] visited) {
        if(visited[node] == 1) return 0;
        visited[node] = 1;
        int height = 0;
        for(int node1 : adjList.get(node)) {
            height = Math.max(height, getHeightOfTree(node1, adjList, visited));
        }
        return 1 + height;
    }
    private int getDiameter(Map<Integer, List<Integer>> adjList) {
        if(adjList.size() == 0) return 0;
        int start = 0;
        int lastNode = bfsGetLastNode(start, adjList);
        int[] visited = new int[adjList.size()];
        int height = getHeightOfTree(lastNode, adjList, visited);
        return height - 1;
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
           Map<Integer, List<Integer>> adjList1 = new HashMap<>();
           Map<Integer, List<Integer>> adjList2 = new HashMap<>();
           for(int[] edge : edges1) {
            adjList1.putIfAbsent(edge[0], new ArrayList<>());
            adjList1.putIfAbsent(edge[1], new ArrayList<>());
            adjList1.get(edge[0]).add(edge[1]);
            adjList1.get(edge[1]).add(edge[0]);
           }

           for(int[] edge : edges2) {
            adjList2.putIfAbsent(edge[0], new ArrayList<>());
            adjList2.putIfAbsent(edge[1], new ArrayList<>());
            adjList2.get(edge[0]).add(edge[1]);
            adjList2.get(edge[1]).add(edge[0]);
           }

           int d1 = getDiameter(adjList1);
           int d2 = getDiameter(adjList2);
           int d3 = (d1 + 1)/2 + (d2 + 1)/2 + 1;
           if(Math.abs(d1 - d2) <= 1) return d3;

           return Math.max(d3, Math.max(d1, d2));
            // return Math.max(d1, d2);
    }
}