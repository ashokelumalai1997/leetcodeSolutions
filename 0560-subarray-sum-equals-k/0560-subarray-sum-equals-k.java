class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freqSum = new HashMap<>();
        int sum = 0;
        int[] suffixSum = new int[nums.length + 1];
        int results = 0;
        freqSum.put(0, 1);
        for(int i = 0; i < nums.length; i ++) {
            suffixSum[i + 1] = suffixSum[i] + nums[i];
            if(freqSum.containsKey(suffixSum[i + 1] - k)) {
                results += freqSum.get(suffixSum[i + 1] - k);
            }
            freqSum.put(suffixSum[i + 1], freqSum.getOrDefault(suffixSum[i + 1], 0)+1);
        }
        
        return results;

    }
}