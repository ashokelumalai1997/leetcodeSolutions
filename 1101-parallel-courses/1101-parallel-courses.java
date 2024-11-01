class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();


        for(int i = 1; i <= n; i++) adjList.put(i, new ArrayList<>());

        int[] inDegree = new int[n+1];

        for(int[] rel : relations) {

            adjList.get(rel[0]).add(rel[1]);
            inDegree[rel[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int sems = 0;

        // if(!q.isEmpty()) sems = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            sems++;
            while(size != 0) {
                size--;
                int currentCourse = q.poll();

                // boolean newCourseAdded = false;

            for(int node : adjList.get(currentCourse)) {
                inDegree[node]--;
                if(inDegree[node] == 0) {
                    q.offer(node);
                    // newCourseAdded = true;
                }
            }

            // if(newCourseAdded == true) sems++;
            }
            
        }

        for(int i = 1; i <= n; i++) {
            if(inDegree[i] != 0) return -1;
        }

        return sems;
    }
}