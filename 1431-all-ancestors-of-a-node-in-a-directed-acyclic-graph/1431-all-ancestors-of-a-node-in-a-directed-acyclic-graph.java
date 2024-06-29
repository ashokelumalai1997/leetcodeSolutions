class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] inDegreeCount = new int[n];
        for(int[] edge: edges) {
            inDegreeCount[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i ++) {
            if(inDegreeCount[i] == 0) q.offer(i);
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
        List<Set<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            result.add(new HashSet<>());
        }


        while(!q.isEmpty()) {
            int currentNode = q.poll();
            List<Integer> currentList = adjList.get(currentNode);
            for(int node : currentList) {
                result.get(node).addAll(result.get(currentNode));
                result.get(node).add(currentNode);
                inDegreeCount[node]--;
                if(inDegreeCount[node] == 0) q.offer(node);
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for(int i = 0; i < n; i ++) {
            resultList.add(new ArrayList<>(result.get(i)));
            Collections.sort(resultList.get(i));
        }
        return resultList;
    }
}