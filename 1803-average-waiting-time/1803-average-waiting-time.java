class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currentStartTime = 0;
        long totalWaitTime = 0;
        int currentEndTime = 0;
        int currentDelay = 0;
        for(int[] customer : customers) {
            currentStartTime = Math.max(customer[0], currentStartTime);
            currentEndTime = currentStartTime + customer[1];
            currentDelay = currentEndTime - customer[0];
            totalWaitTime += currentDelay;
            currentStartTime = currentEndTime;
        }
        return (double)totalWaitTime/customers.length;
    }
}