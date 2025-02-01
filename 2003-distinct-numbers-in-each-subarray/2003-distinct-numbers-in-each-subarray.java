class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        
        int left = 0;
        int right = 0;


        int[] res = new int[n-k+1];

        Map<Integer, Integer> freqMap = new HashMap<>();


        while(right < n) {
            if(right - left +1 > k) {
                int currentCount = freqMap.get(nums[left]);
                if(currentCount == 1) {
                    freqMap.remove(nums[left]);
                } else {
                    freqMap.put(nums[left], currentCount-1);
                }
                left++;
            }
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right],0)+1);
            if(right-k+1 >= 0) {
                res[right-k+1] = freqMap.size();

                // 0 1 2 3 4 , k = 2
            }
            right++;
        }

        return res;
    }
}