class Task  implements Comparable<Task> {

    int start;
    int processingTime;
    int index;

    public Task(int s, int p, int i) {
        this.start = s;
        this.processingTime = p;
        this.index = i;
    }

    public int compareTo(Task o) {
        if(processingTime == o.processingTime) return index - o.index;
        return processingTime - o.processingTime;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        int n = tasks.length;
        for(int i = 0; i < n; i++) {
            taskList.add(new Task(tasks[i][0], tasks[i][1], i));
        }
        Collections.sort(taskList, (a,b) -> a.start - b.start);

        int current = taskList.get(0).start;

        int taskTracker = 0;

        PriorityQueue<Task> pq = new PriorityQueue<>();

        while(taskTracker < n && taskList.get(taskTracker).start == current) {
            pq.offer(taskList.get(taskTracker));
            taskTracker++;
        }

        

        int[] taskOrder = new int[n];

        int taskOrderTracker = 0;

        while(!pq.isEmpty()) {
            Task currentTask = pq.poll();
            taskOrder[taskOrderTracker] = currentTask.index;
            taskOrderTracker++;
            current = current + currentTask.processingTime;

            if(taskTracker < n && pq.isEmpty()) {
               current = Math.max(current, taskList.get(taskTracker).start);
            }
            
            for(; 
                        taskTracker < n && taskList.get(taskTracker).start <= current; taskTracker++) {
                pq.offer(taskList.get(taskTracker));
            }
            // if(pq.isEmpty() && taskTracker < n) {
            //     current = taskList.get(taskTracker).start;
            //     while(taskTracker < n && taskList.get(taskTracker).start <= current) {
            //         pq.offer(taskList.get(taskTracker));
            //         taskTracker++;
            //     }
            // }
            // taskTracker = i;
        }

        return taskOrder;


    }
}