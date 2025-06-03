class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		Queue<Integer> courseQ = new LinkedList<>();
		
		int[] inDegree = new int[numCourses];
		
		List<List<Integer>> adjlist = new ArrayList<>();

		for(int i = 0; i < numCourses; i++) {
			adjlist.add(new ArrayList<>());
}
		
		for(int[] dep : prerequisites) {
			adjlist.get(dep[1]).add(dep[0]);
			inDegree[dep[0]]++;
}

for(int i = 0; i < numCourses; i++) {
	if(inDegree[i] == 0) {
		courseQ.add(i);
}
}
int completed = 0;

while(!courseQ.isEmpty()) {
	completed++;
	int current = courseQ.poll();
	
	for(int next : adjlist.get(current)) {
		inDegree[next]--;
		if(inDegree[next] == 0) {
			courseQ.add(next);
}
}
}

return (completed == numCourses);
}

}
