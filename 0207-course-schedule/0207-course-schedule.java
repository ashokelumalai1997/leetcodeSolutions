class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[n];
        int in = 0;

        while(in < n) {
            adj.add(new ArrayList<>());
            in++;
        }


        for(int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
            inDeg[prereq[0]]++;
        }


        Queue<Integer> q = new LinkedList<>();




        for(int i = 0; i < n; i++) {
            if(inDeg[i] == 0) {
                q.offer(i);
            }
        }

        int coursesCompleted = 0;

        while(!q.isEmpty()) {

            int currentCourse = q.poll();

            for(int next : adj.get(currentCourse)) {
                inDeg[next]--;
                if(inDeg[next] == 0) {
                    q.offer(next);
                }
            }

            coursesCompleted++;

        }

        return coursesCompleted == numCourses;



    }
}