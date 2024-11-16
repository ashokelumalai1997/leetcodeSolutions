class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        int n = nums.length;
        int left = 0;

        int right = 0;

        long current = 0;

        Map<Integer, Integer> counter = new HashMap<>();

        while(right < n) {
            if(left < right-k+1) {
                int currentCount = counter.get(nums[left]);
                if(currentCount == 1) {
                    counter.remove(nums[left]);
                } else {
                    counter.put(nums[left], currentCount-1);
                }
                current -= nums[left];
                left++;
            }
            current += nums[right];
            counter.put(nums[right], counter.getOrDefault(nums[right], 0)+1);

            if(counter.size() == k) {
                res = Math.max(res, current);
            }

            right++;
        }

        return res;

    }
}