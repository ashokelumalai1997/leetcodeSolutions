
class Solution {
    /*
    f(index)

iterate till index + k -1 -> i
    max = math.max(max, num[i])
    calculate max*(i-index+1) + f(i+1)
    */
    private int cutOrContinue(int[] dp, int ind, int[] arr, int k) {
        
        int n = arr.length;
        if(ind == n) return 0;
        if(dp[ind] != -1) return dp[ind];
        int max = arr[ind];
        int maxRes = 0;
        for(int i = ind; i < ind+k && i < n; i++) {
            max = Math.max(max, arr[i]);
            int current = max*(i-ind+1) + cutOrContinue(dp, i+1, arr, k);
            maxRes = Math.max(maxRes, current);
        }

        return dp[ind] = maxRes;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return cutOrContinue(dp, 0, arr, k);
    }
}


// cutOrContine


// arr = [1,15,7,9,2,5,10], k = 3





// 1 []

// max =1

// 1 + f([])

// 1,15 []

// 2*15 + f([])

// max = 15

// 1,15,7 []

// max = 15

// 3*15 + f([])