class Solution {
    private int getMaximumLengthOfGoodSeq(int[] nums, int index, int runningIndices, int k, int lastIndexTaken, int[][] cache) {
	    if( index == nums.length) return 0;
        if(cache[lastIndexTaken + 1][runningIndices] != -1) return cache[lastIndexTaken + 1][runningIndices];
        
        int notTaken = getMaximumLengthOfGoodSeq(nums, index+1, runningIndices, k, lastIndexTaken, cache);//[1,2,1,1,3], 1, 0, 3, -1
        
        if(lastIndexTaken != -1 && nums[lastIndexTaken] != nums[index]) runningIndices++;//runningIndices = 0
        

        int taken = 0;
        if(runningIndices <=k)taken =1 + getMaximumLengthOfGoodSeq(nums, index+1, runningIndices, k, index, cache);
        if(lastIndexTaken != -1 && nums[lastIndexTaken] != nums[index]) runningIndices--;
        cache[lastIndexTaken + 1][runningIndices] = Math.max(taken, notTaken);
        
        return cache[lastIndexTaken + 1][runningIndices];
    }
    public int maximumLength(int[] nums, int k) {
        int[][] cache = new int[nums.length+1][k+2];
        for(int i = 0; i < cache.length; i ++) {
            for(int j = 0 ; j < cache[i].length; j ++) {
                cache[i][j] = -1;
            }
        }
        return getMaximumLengthOfGoodSeq(nums, 0, 0, k, -1, cache);
    }
}