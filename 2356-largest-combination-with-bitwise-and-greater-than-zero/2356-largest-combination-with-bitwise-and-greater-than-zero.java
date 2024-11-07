class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitTracker = new int[32];     
        int n = candidates.length;
        for(int i = 0; i < n; i++) {
            int num = candidates[i];
            int bit = 0;
            while(bit < 31) {
                bitTracker[bit] += (((1 << bit)&num) > 0) ? 1 : 0;
                bit++;
            }
        }

        int max = 0;

        for(int i = 0; i < 32; i++) {
            max = Math.max(max, bitTracker[i]);
        }

        return max;
    }
}

// 32 bits

// 1/0 1/0 1/0 1/0 ..... 
// 1/0 1/0 1/0 1/0 ..... 
// 1/0 1/0 1/0 1/0 ..... 
// 1/0 1/0 1/0 1/0 ..... 


