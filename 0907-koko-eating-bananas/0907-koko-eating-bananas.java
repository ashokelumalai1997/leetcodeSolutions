class Solution {
    private long getTotalHoursToEat(int[] piles, int K){
        long totalHours = 0;
        for(int pile : piles) {
            totalHours += pile/K;
            if(pile%K != 0) totalHours++;
        }
        return  totalHours;
    }
    public int minEatingSpeed(int[] piles, int H) {
        int maxK = 0;
        for(int pile : piles) {
            maxK = Math.max(pile, maxK);
        }
        int low = 1;
        int high = maxK; //11
        int minimumK = 0;
        while(low <= high) {
            int mid = low + (high-low)/2; //6
            if(getTotalHoursToEat(piles, mid) > (long)H) {
                low = mid + 1;
            } else {
                minimumK = mid;
                high = mid - 1;
            }
        }
        return minimumK;
    }
}