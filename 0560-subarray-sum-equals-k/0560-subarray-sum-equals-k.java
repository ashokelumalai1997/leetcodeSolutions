class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freqSum = new HashMap<>();
        int sum = 0;
        int results = 0;
        freqSum.put(0, 1);
        for(int i = 0; i < nums.length; i ++) {
            sum = sum + nums[i];
            if(freqSum.containsKey(sum - k)) {
                results += freqSum.get(sum - k);
            }
            freqSum.put(sum, freqSum.getOrDefault(sum, 0)+1);
        }
        
        return results;

    }
}