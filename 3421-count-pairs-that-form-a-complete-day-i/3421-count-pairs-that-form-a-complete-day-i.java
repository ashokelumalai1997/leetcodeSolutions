class Solution {
    public int countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> hoursFreqCounter = new HashMap<>();
        int result = 0;
        for(int hour : hours) {
            int neededHour =  hour%24;
            if(neededHour != 0) neededHour = 24 - neededHour;
            if(hoursFreqCounter.containsKey(neededHour)) {
                result += hoursFreqCounter.get(neededHour);
            }
            hoursFreqCounter.put(hour%24, hoursFreqCounter.getOrDefault(hour%24, 0) + 1);
        }
        return result;
    }
}