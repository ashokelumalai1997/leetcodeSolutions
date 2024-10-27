class Solution {
    private long lcm(long a, long b){
        return a*b/gcd(a,b);
    }
    
    private long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b%a, a);
    }
    public long maxScore(int[] nums) {
        int n = nums.length;

        // edge
        if (n == 1) {
            return (long) nums[0] * nums[0];
        }

        long tgcd = nums[0];
        long tlcm = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tgcd = gcd((long)tgcd, (long)nums[i]);
            tlcm = (tlcm * nums[i]) / gcd(tlcm, (long)nums[i]);
        }

        long maxScore = tgcd * tlcm;
        for (int i = 0; i < n; i++) {
            long ngcd = 0;
            long nlcm = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    ngcd = ngcd == 0 ? nums[j] : gcd(ngcd, (long)nums[j]);
                    nlcm = (nlcm * nums[j]) / gcd(nlcm, (long)nums[j]);
                }
            }

            maxScore = Math.max(maxScore, ngcd * nlcm);
        }
        return maxScore;
    }
}


// 2*3*2*2 = 24 
    
// 2*5*2 = 20


// GCD = 4

// LCM = 120

