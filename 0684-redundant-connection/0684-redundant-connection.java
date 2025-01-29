class UnionFind {
    int[] parent;
    public UnionFind(int n) {
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public boolean union(int u, int v) {
        if(find(u) == find(v)) return false;

        parent[parent[u]] = parent[v];

        return true;
    }

    public int find(int node) {
        if(parent[node] == node) return node;

        return parent[node] = find(parent[node]);
    }

}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++) {
            if(!uf.union(edges[i][0], edges[i][1])) return edges[i];
        }
        return new int[]{};
    }
}