class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int numberOfSatisfiedCustomers = 0;
        int n = customers.length;
        for(int i = 0; i < n; i ++) {
            if(grumpy[i] == 0) numberOfSatisfiedCustomers += customers[i];
        }
        int start = 0;
        int end = 1;
        int currentPossibleCustomersToSatisfy = grumpy[0] == 1 ? customers[0] : 0;
        int maximumCustomersToSatisfy = currentPossibleCustomersToSatisfy;
        while(end < n) {
            if(end - start < minutes) {
                currentPossibleCustomersToSatisfy += grumpy[end] == 1 ? customers[end] : 0;
                end++;
                continue;
            }
            maximumCustomersToSatisfy = Math.max(maximumCustomersToSatisfy, currentPossibleCustomersToSatisfy);
            currentPossibleCustomersToSatisfy -= grumpy[start] == 1 ? customers[start] : 0;
            currentPossibleCustomersToSatisfy += grumpy[end] == 1 ? customers[end] : 0;
            start++;
            end++;
        }
        maximumCustomersToSatisfy = Math.max(maximumCustomersToSatisfy, currentPossibleCustomersToSatisfy);
        return maximumCustomersToSatisfy + numberOfSatisfiedCustomers;

    }
}