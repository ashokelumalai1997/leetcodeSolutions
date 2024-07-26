class Solution {
    public int findTheCity(int n, int[][] edgesL, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < edgesL.length; i++) {
            int[] edges = edgesL[i];
            dist[edges[0]][edges[1]] = edges[2];
            dist[edges[1]][edges[0]] = edges[2];
        }
        for(int i = 0; i < n; i++) {
            dist[i][i] = 0; // Distance from a node to itself is 0
        }
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int[] counter = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && dist[i][j] <= distanceThreshold) counter[i]++;
            }
        }

        int result = 0;
        int resultCount = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(counter[i] <= resultCount) {
                resultCount = counter[i];
                result = i;
            }
        }
        return result;
    }
}
