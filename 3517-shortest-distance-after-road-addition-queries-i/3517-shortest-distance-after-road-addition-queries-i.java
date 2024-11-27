class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            adjList.add(new ArrayList<>());
            if(i < n-1) {
                adjList.get(i).add(i+1);
            }
        }


        int[] distances = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            adjList.get(q[0]).add(q[1]);
            distances[i] = bfs(adjList);
        }

        return distances;
    }

    private int bfs(List<List<Integer>> adjList) {
        Queue<Integer[]> q = new LinkedList<>();
        int[] visited = new int[adjList.size()]; 

        q.offer(new Integer[]{0,0});

        visited[0] = 1;

        while(!q.isEmpty()) {
            Integer[] current = q.poll();

            if(current[0] == adjList.size() - 1) return current[1];

            for(int child : adjList.get(current[0])) {
                if(visited[child] == 0) {
                    q.offer(new Integer[]{child, current[1]+1});
                    visited[child] = 1;
                }
            }
        }
        return -1;
    }
}