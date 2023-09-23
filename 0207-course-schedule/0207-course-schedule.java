class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Create a adj list of vertex to child
        //Create a a hashMap of indegree
        //Push all the sources to a Queue
        //When Queue is not empty, pick source one by one
        //Push the value to a list
        //Decrease indegree of all it's childs
        //If indegree is zero for any child push it to Queue
        //Remove the current node from the queue
        List<Integer>[] adjList = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adjList[i]=new ArrayList();
        }
        HashMap<Integer,Integer> inDegree = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            inDegree.put(i,0);
        }
        System.out.println(inDegree.toString());
        for(int i=0;i<prerequisites.length;i++){
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
            inDegree.put(prerequisites[i][1],inDegree.get(prerequisites[i][1])+1);
        }
        Queue<Integer> sourceQ = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()){
            
            System.out.println(entry.toString());
            int val=entry.getValue();
            if(val==0){
                sourceQ.offer(entry.getKey());
            }
        }
        List<Integer> sortedOrder = new ArrayList<>();
        while(!sourceQ.isEmpty()){
            int currentSource = sourceQ.peek();
            sourceQ.poll();
            sortedOrder.add(currentSource);
            for(Integer node : adjList[currentSource]){
                inDegree.put(node,inDegree.get(node)-1);
                if(inDegree.get(node)==0)
                    sourceQ.offer(node);
            }
        }
        //System.out.println(sortedOrder.toString());
        if(sortedOrder.size()!=numCourses)
            return false;
        return true;

    }
}