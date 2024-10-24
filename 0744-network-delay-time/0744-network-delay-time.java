class Solution {
    private Map<Integer, List<int[]>> prepareAdjacencyList(int[][] times) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int[] time : times) {
            int source = time[0];
            int target = time[1];
            int timeN = time[2];
            adjList.putIfAbsent(source, new ArrayList<>());
            adjList.get(source).add(new int[]{target, timeN});
        }
        for(List<int[]> l : adjList.values()) {
            Collections.sort(l, (a, b)-> a[1]-b[1]);
        }
        return adjList;
    }

    private int result(int[] visited) {
        int result = visited[0];
        for(int i = 1; i < visited.length; i ++) {
            if(visited[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, visited[i]);
        }
        return result;
    }

    
    public int networkDelayTime(int[][] times, int n, int k) {
        int result = 0;
        Map<Integer, List<int[]>> adjList = prepareAdjacencyList(times);
        int[] visited = new int[n+1];
        for(int i = 1; i <= n; i++) visited[i] = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{k, 0});
        visited[k] = 0;
        while(!q.isEmpty()) {
            int[] currentNodeDetail = q.poll();
            int currentNode = currentNodeDetail[0];
            int currentTime = currentNodeDetail[1];
            result = Math.max(result, currentTime);
            if(!adjList.containsKey(currentNode)) continue;
            for(int[] nodeDetail : adjList.get(currentNode)) {
                int node = nodeDetail[0];
                int time = nodeDetail[1];
                if(visited[node] > currentTime + time) {
                    q.offer(new int[]{node, currentTime + time});
                    visited[node] = currentTime + time;
                }
            }
        }
        return result(visited);
    }
    

    
}