class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        int[] LDS = new int[n];
        // LIS[n-1] = 1;
        Arrays.fill(LDS, 1);
        Arrays.fill(LIS, 1);
        //          [9,8,1,7,6,5,4,3,2,1]
        // LIS      [1,1,1,2,2,2,2,2,2,1]
        // LDS      [8,7,1,7,6,5,4,3,2,1]
        for(int i = 0; i < n; i++ ) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i])
                LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
            }
        }

        for(int i = n-1; i >= 0; i-- ) {
            for(int j = i+1; j < n; j++) {
                
                if(nums[j] < nums[i])
                LDS[i] = Math.max(LDS[i], 1 + LDS[j]);
            }
        }

       int minRemoval = n;
for(int i = 0; i < n; i++) {
    // Only consider point i if it's a valid mountain peak
    if (LIS[i] > 1 && LDS[i] > 1) {
        minRemoval = Math.min(minRemoval, n - (LIS[i] + LDS[i] - 1));
    }
}

        return minRemoval;

    }
}