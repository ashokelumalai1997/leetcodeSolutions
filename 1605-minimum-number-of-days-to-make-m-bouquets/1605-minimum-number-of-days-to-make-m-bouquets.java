class Solution {
    private int numberOfBouqetsPossible(int day, int[] bloomDay, int k){
        int numberOfBouqets = 0;
        int flowers = 0;
        for(int i = 0; i < bloomDay.length; i ++) {
            if(bloomDay[i] <= day) flowers++;
            else flowers = 0;

            if(flowers == k) {
                numberOfBouqets++;
                flowers = 0;
            }
        }
        return numberOfBouqets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int minDay = 0;
        int maxDay = 0;
        for(int day : bloomDay) {
            maxDay = Math.max(day, maxDay);
        }
        int result = -1;
        while(minDay <= maxDay) {
            int midDay = minDay + (maxDay - minDay)/2;
            if(numberOfBouqetsPossible(midDay, bloomDay, k) >= m) {
                result = midDay;
                maxDay = midDay - 1;
            } else {
                minDay = midDay + 1;
            }
        }
        return result;
    }
}