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
            dist[edges[0]][edges[0]] = 0;
            dist[edges[1]][edges[1]] = 0;
        }
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(dist[j][i] == Integer.MAX_VALUE || dist[i][k] == Integer.MAX_VALUE) continue;
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++) {
                // for(int k = 0; k < n; k++) {
                    // if(dist[i][j] == Integer.MAX_VALUE || dist[j][k] == Integer.MAX_VALUE) continue;
                    // dist[i][k] = Math.min(dist[i][k], dist[i][j] + dist[j][k]);
                    System.out.println("Distance from " + i + " to " + j + " " + dist[i][j]);
                // }
            }
        }


        int[] counter = new int[n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++) {
                if(i != j && dist[i][j] <= distanceThreshold) counter[i]++;
            }
        }
        int result = 0;
        int resultCount = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            // System.out.print(i + " " + counter[i] + "\n");
            if(counter[i] <= resultCount) {
                resultCount = counter[i];
                result = i;
            }
        }
        return result;
    }
}