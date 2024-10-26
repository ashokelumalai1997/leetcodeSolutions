class Solution {
    private int findSizes(int parent, int node, Map<Integer, List<Integer>> adjList, int[] sizes, String s, int[] ancestor) {
        sizes[node] += 1;
        char currentChar = s.charAt(node);
        int prevAnc = ancestor[currentChar - 'a'];
        ancestor[currentChar - 'a'] = node;
        for(int i : adjList.get(node)) {
            int anc = ancestor[s.charAt(i)-'a'];
            int temp = findSizes(node, i, adjList, sizes, s, ancestor);
            if(anc == -1 || s.charAt(node) == s.charAt(i)) sizes[node] += temp;
            else sizes[anc] += temp;
        }
        ancestor[currentChar - 'a'] = prevAnc;
        // if(parent == -1 || s.charAt(node) == s.charAt(parent)) return sizes[node];
        // if(ancestor[s.charAt(node) - 'a'] == -1) return sizes[node];
        // int anc = ancestor[s.charAt(node) - 'a'];
        // sizes[anc] += sizes[node];
        return sizes[node];
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int n = s.length();
        for(int i = 0; i < n; i++) adjList.put(i, new ArrayList<>());
        for(int i = 1; i < n; i++) {
            // adjList.putIfAbsent(parent[i], new ArrayList<>());
            adjList.get(parent[i]).add(i);
        }
        int[] ancestor = new int[26];
        Arrays.fill(ancestor, -1);
        int[] sizes = new int[n];
        sizes[0] = findSizes(-1, 0, adjList, sizes, s, ancestor);
        return sizes;
    }
}