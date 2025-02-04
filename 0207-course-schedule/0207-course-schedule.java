class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for(int[] preReq : prerequisites) {
            adjList.get(preReq[1]).add(preReq[0]);
            inDegree[preReq[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int processedCourses = 0;

        while(!q.isEmpty()) {
            int currentCourse = q.poll();


            for(int nextCourse : adjList.get(currentCourse)) {
                inDegree[nextCourse]--;
                if(inDegree[nextCourse] == 0) {
                    q.offer(nextCourse);
                }
            }
            processedCourses++;
        }

        return processedCourses == numCourses;


    }
}