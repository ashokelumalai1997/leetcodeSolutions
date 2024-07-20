class Solution {
    public int minChanges(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int[] freqOfDiffs = new int[k+1];
        while(l < r) {
            int diff = Math.abs(nums[l] - nums[r]);
            int current = mp.getOrDefault(diff, 0);
            mp.put(diff, current + 1);
            
            int max = Math.max(nums[l], nums[r]);
            int min = Math.min(nums[l], nums[r]);
            freqOfDiffs[ diff + Math.max(min, k-max)]++;
            l++;
            r--;
        }
        for(int i = k-1; i >= 0; i--) {
            freqOfDiffs[i] += freqOfDiffs[i+1];
        }
        int overallResult = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> pair : mp.entrySet()) {
            int key = pair.getKey();
            int value = pair.getValue();
            int l1 = 0;
            int r1 = n-1;
            int result = 0;
            result += (freqOfDiffs[key] - value);
            result += n/2 - (freqOfDiffs[key]);
            result += n/2 - (freqOfDiffs[key]);
            
            // if(result > overallResult) break;
            overallResult = Math.min(overallResult, result);
        }
        return overallResult;
    }
}