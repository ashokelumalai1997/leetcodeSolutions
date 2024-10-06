public class UnionFind {
    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean[] s = new boolean[n];
        for(int i = 0; i < n; i++) s[i] = false;
        s[k] = true;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        UnionFind uf = new UnionFind(n);
        
        for(int[] inv : invocations) {
            adjList.putIfAbsent(inv[0], new ArrayList<>());
            adjList.get(inv[0]).add(inv[1]);
            uf.union(inv[0], inv[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        boolean[] v = new boolean[n];
        v[k] = true;
        while(!q.isEmpty()) {
            int c = q.poll();
            if(adjList.get(c) == null) continue;
            for(int i : adjList.get(c)) {
                s[i] = true;
                if(v[i]) continue;
                q.add(i);
                v[i] = true;
            }
        }
        int parK = uf.find(k);
        
        Set<Integer> l = new HashSet<>();
        for(int i = 0; i < n; i++) l.add(i);
        Set<Integer> ls = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(uf.find(i) == parK) {
                if(s[i] != true) return new ArrayList<>(l);
                else ls.add(i);
            }
        }
        l.removeAll(ls);
        return new ArrayList<>(l);
    }
}