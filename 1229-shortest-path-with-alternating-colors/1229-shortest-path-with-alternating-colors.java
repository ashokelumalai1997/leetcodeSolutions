class AdjEntry{

    int node;
    int color;

    public AdjEntry(int n, int c) {
        this.node = n;
        this.color = c;
    }
}

class QEntry {
    int node;
    int dist;
    int color;

    public QEntry(int n, int d, int c) {
        this.node = n;
        this.dist = d;
        this.color = c;
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        Map<Integer, List<AdjEntry>> adjList = new HashMap<>();
        for(int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : redEdges) {
            adjList.get(edge[0]).add(new AdjEntry(edge[1], 0));
        }

        for(int[] edge : blueEdges) {
            adjList.get(edge[0]).add(new AdjEntry(edge[1], 1));
        }

        Queue<QEntry> q = new LinkedList<>();

        q.offer(new QEntry(0, 0, 0));
        q.offer(new QEntry(0, 0, 1));

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        boolean[][] visited = new boolean[n][2];
        visited[0][0] = true;
        visited[0][1] = true;

        while(!q.isEmpty()) {
            QEntry current = q.poll();
            int currentNode = current.node;
            int currentDist = current.dist;
            int currentColor = current.color;

            int neededColor = currentColor == 1 ? 0 : 1;

            for(AdjEntry a : adjList.get(currentNode)) {
                if(a.color == neededColor 
                    && visited[a.node][neededColor] == false) {
                        visited[a.node][neededColor] = true;
                        dist[a.node] = Math.min(1 + currentDist, dist[a.node]);
                        q.offer(new QEntry(a.node, 1+currentDist, neededColor));

                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;


    }
}




// [nodeId, distanceFromSource, latNodeColour]

// while(q has entry) {
//     poll current entry
//     push all the nodes connected to current node(only unvisited)
// }