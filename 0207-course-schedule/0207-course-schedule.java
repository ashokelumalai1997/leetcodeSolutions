class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int c = 0; c < numCourses; c++) {
            adj.add(new ArrayList<>());
        }
        for(int[] pr : prerequisites) {
            inDegree[pr[1]]++;
            adj.get(pr[0]).add(pr[1]);

        }


        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if( inDegree[i] == 0 ) {
                q.offer(i);
            }
        }

        int courses = 0;

        while(!q.isEmpty()) {
            int currentCourse = q.poll();

            courses++;

            for(int child : adj.get(currentCourse)) {
                inDegree[child]--;
                if(inDegree[child] == 0) {
                    q.offer(child);
                }
            }
        }

        return courses == numCourses;
    }
}

//     1       2       3       4       5       6
//         7       8       9
//             10      11
//                 12

// push courses without prereq into queue


// poll from q one by one
//     each poll is a course

//     deduct prereqs of child courses
//     if(child course becomes zero prereq) push it to q


// numCourses must have been polled