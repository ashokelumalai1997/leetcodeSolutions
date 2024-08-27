class Solution {
    class EdgeInfo {
        int to;
        double prob;
        public EdgeInfo(int to, double prob) {
            this.to = to;
            this.prob = prob;
        }
    }
    class NodeInfo{
        int node;
        double prob;
        public NodeInfo(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<EdgeInfo>> adjList  = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adjList.putIfAbsent(edge[1], new ArrayList<>());
            adjList.putIfAbsent(edge[0], new ArrayList<>());
            adjList.get(edge[0]).add(new EdgeInfo(edge[1], succProb[i]));
            adjList.get(edge[1]).add(new EdgeInfo(edge[0], succProb[i]));
        }
        PriorityQueue<NodeInfo> pq = new PriorityQueue<>((a,b) -> Double.compare(b.prob, a.prob));
        pq.offer(new NodeInfo(start_node, 1));
        double[] probs = new double[n];
        probs[start_node] = 1;
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()) {
            NodeInfo current = pq.poll();
            if(!visited[current.node]) {
                visited[current.node] = true;
                if(adjList.get(current.node) == null) continue;
                for(EdgeInfo e : adjList.get(current.node)) {
                    probs[e.to] = Math.max(probs[current.node]*e.prob, probs[e.to]);
                    pq.offer(new NodeInfo(e.to, probs[e.to]));
                }
            }
        }
        return probs[end_node];
    }
}