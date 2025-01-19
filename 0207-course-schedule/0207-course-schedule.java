class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for(int[] course : prerequisites) {
            adjList.get(course[1]).add(course[0]);
            inDegree[course[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) q.offer(i);
        }

        int numComplete = 0;

        while(!q.isEmpty()) {
            int current = q.poll();

            numComplete++;

            for(int ne : adjList.get(current)) {
                inDegree[ne]--;
                if(inDegree[ne] == 0) q.offer(ne);
            }
        }

        return numCourses == numComplete;



    }
}