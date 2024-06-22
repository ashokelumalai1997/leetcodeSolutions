class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int evensAtStart = 0;
        int currentWindowOddCount = 0;
        int result = 0;
        while(right < nums.length) {
            currentWindowOddCount += nums[right]%2;
            if(currentWindowOddCount == k) {
                evensAtStart = 0;
                while(currentWindowOddCount == k) {
                    evensAtStart++;
                    currentWindowOddCount -= nums[left]%2;
                    left++;
                }
            }
            result += evensAtStart;
            right++;
        }
        return result;
    }
}