class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> modFreqCounter = new HashMap<>();
        modFreqCounter.put(0 , 1);
        int currentMod = 0;
        int results = 0;
        for(int i = 0; i < nums.length; i ++) {
            currentMod = (currentMod + nums[i]%k +k) % k;
            results += modFreqCounter.getOrDefault(currentMod, 0);
            modFreqCounter.put(currentMod, modFreqCounter.getOrDefault(currentMod, 0)+1);
        }
        return results;
    }
}