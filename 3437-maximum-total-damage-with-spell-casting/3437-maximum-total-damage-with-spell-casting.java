class Solution {
    private long getMaxDamage(int index, int[] power, 
                                Map<String, Long> dp) { 
        if(index == power.length) return 0;

        String key = String.valueOf(index);

        if(dp.containsKey(key)) return dp.get(key);
        int temp = index + 1;
        while(temp < power.length && power[temp] == power[index]) {
            temp++;
        }
        int temp1 = temp;
        while(temp1 < power.length && power[temp1] <= (power[index] + 2)) {
            temp1++;
        }

        long dontTake = 0;
        dontTake = getMaxDamage(temp, power, dp);

        long take = 0;
        take = (long)power[index]*(temp - index) + getMaxDamage(temp1, power, dp);

        dp.put(key, Math.max(take, dontTake));

        return dp.get(key);
    }
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int startIndex = 0;
        Map<String, Long> dp = new HashMap<>();
        return getMaxDamage(startIndex, power, dp);
    }
}