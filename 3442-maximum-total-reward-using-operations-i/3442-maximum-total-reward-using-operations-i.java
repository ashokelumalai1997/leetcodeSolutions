class Solution {
    private int getMaxReward(int index, int[] rewardValues, int currentReward, int[][] cache) {
        if(index == rewardValues.length) return 0;
        // String key = String.valueOf(index) + ":" + String.valueOf(currentReward);
        // if(cache.containsKey(key)) return cache.get(key);
        if(cache[index][currentReward] != -1) return cache[index][currentReward];
        int take = 0;
        if(currentReward < rewardValues[index]) {
            take = rewardValues[index] + getMaxReward(index + 1, rewardValues, currentReward + rewardValues[index], cache);
        }
        int notTake = getMaxReward(index + 1, rewardValues, currentReward, cache);
        // cache.put(key, Math.max(take, notTake));
        return cache[index][currentReward] = Math.max(take, notTake);
        
    }
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int sum = 0;
        for(int r : rewardValues) {
            sum += r;
        }
        int[][] cache = new int[rewardValues.length][Math.min((int)Math.pow(10,4)+1,sum+1)];
        // Map<String, Integer> cache = new HashMap<>();
        for(int i = 0; i < cache.length; i ++) {
            Arrays.fill(cache[i], -1);
        }
        return getMaxReward(0, rewardValues, 0, cache);
    }
}