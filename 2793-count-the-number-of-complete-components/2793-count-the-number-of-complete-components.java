class Solution {

	public int[] dfs(int node, Set<Integer> visited, 
Map<Integer, List<Integer>> adjList) {
		int[] res = new int[2];
        if(visited.contains(node)) return res;
		visited.add(node);
		
		res[0] = 1;
		res[1] = adjList.get(node).size();
		
		for(int neighbor : adjList.get(node)) {
			if(visited.contains(neighbor)) continue;
			int[] nRes = dfs(neighbor, visited, adjList);
			res[0] += nRes[0];
			res[1] += nRes[1];
}
return res;
}


public int countCompleteComponents(int n, int[][] edges) {
	Map<Integer, List<Integer>> adjList = new HashMap<>();
for(int i = 0; i < n; i++) {
	adjList.put(i, new ArrayList<>());
}

for(int[] edge : edges) {
	adjList.get(edge[0]).add(edge[1]);
	adjList.get(edge[1]).add(edge[0]);
}

Set<Integer> visited = new HashSet<>();

int count = 0;

for(int i = 0; i < n; i++) {
	if(visited.contains(i)) continue;
	int[] res = dfs(i, visited, adjList);
	if(res[0]*(res[0]-1) == res[1]) count++;
}

return count;
}
}
