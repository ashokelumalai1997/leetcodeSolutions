class Solution {
    public long countBadPairs(int[] nums) {
        long gPairs = 0;


        Map<Integer, Long> countMap = new HashMap<>();

        int n = nums.length;

        long totalPairs = (long)n*(n-1)/2;


        for(int i = 0; i < n; i++) {
            // if()
            long val = countMap.getOrDefault(nums[i]-i, (long)0);
            gPairs += val;
            countMap.put(nums[i] - i, val+1);
        }

        return totalPairs - gPairs;
    }
}