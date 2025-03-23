// class Solution {
//     public int countPaths(int n, int[][] roads) {
        
//     }
// }


class Solution {

    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]> > adj = new HashMap<>();

        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());

        for(int[] node : roads) {
            adj.get(node[0]).add(new int[]{node[1], node[2]});
            adj.get(node[1]).add(new int[]{node[0], node[2]});
        }


        return numberOfPaths(adj);
    }

	public int numberOfPaths(Map<Integer, List<int[]> > adj) {
		int n = adj.size();
		long[] dist = new long[n];
		int[] ways = new int[n];

		PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));

		pq.offer(new long[]{0, 0});
		
		Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
		
		ways[0] = 1;

		while(!pq.isEmpty()) {
			long[] current  = pq.poll();
			
			long node = current[0];
			
			long soFarDist = current[1];
			
			for(int[] next : adj.get((int)node)) {
				long newDist = next[1] + soFarDist;
			
				if(newDist < dist[next[0]]) {
					ways[next[0]] = ways[(int)node];
					dist[next[0]] = newDist;
					pq.offer(new long[]{next[0], newDist});
} else if(newDist == dist[next[0]]) {
	ways[next[0]] += ways[(int)node];
    ways[next[0]] %= 1000000007;
}
}
}
return ways[n-1];
}
}