class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        class JobDetail implements Comparable<JobDetail>{
            private int profit;
            private int difficulty;
            public JobDetail(int profit, int difficulty){
                this.profit = profit;
                this.difficulty = difficulty;
            }

            public int compareTo(JobDetail jd) {
                return jd.profit - this.profit;
            }
        }

        PriorityQueue<JobDetail> jobDetails = new PriorityQueue<>();
        for(int i = 0; i < profit.length; i ++) {
            jobDetails.add(new JobDetail(profit[i], difficulty[i]));
        }

        Arrays.sort(worker);

        int i = worker.length - 1;
        int maxProfit = 0;

        while(!jobDetails.isEmpty()) {
            JobDetail currentJob = jobDetails.poll();
            int currentJobProfit = currentJob.profit;
            int currentJobDifficulty = currentJob.difficulty;
            while(i >= 0 && worker[i] >= currentJobDifficulty) {
                System.out.println(currentJobProfit);
                i--;
                maxProfit += currentJobProfit;
            }
        }
        return maxProfit;

        /*
        difficulty[i] - of the job
profit[i] - of the the job
worker[i] - ability of the worker

Each worker can at max do 1 job
Each job can be done multiple times

Maximum profit we can achieve by assigning job to the worker

1. Difficulty doesn't need to be in proportion with profit
2. We may or may not use the total ability of the job. We can even assign low difficulty job to worker with certain ability

Sort the profit in descending order
Pick the job with maximum profit
Assign it to as many workers possible(based on their ability), pop them
Remove the max profit
Go to step 2


        */


    }
}