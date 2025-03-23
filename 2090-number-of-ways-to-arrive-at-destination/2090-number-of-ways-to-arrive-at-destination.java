class Solution {
    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0}); // {node, dist}

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long d = cur[1];

            if (d > dist[u]) continue; // Skip stale entries

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int time = edge[1];
                long newDist = d + time;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new long[]{v, newDist});
                } else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
