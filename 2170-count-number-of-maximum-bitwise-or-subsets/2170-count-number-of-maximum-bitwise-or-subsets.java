class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        int n = nums.length;
        for(int num : nums) {
            maxOr |= num;
        }

        int[][] dp = new int[n][maxOr+1];
        for(int i = 0; i < n; i++) {
            dp[i][nums[i]]++;
        }

        for(int i = n-2; i >= 0 ; i--) {
            for(int j = 0; j <= maxOr; j++) {
                dp[i][j] += dp[i+1][j];
                if(dp[i+1][j] != 0) {
                    int currentOr = j | nums[i];
                    dp[i][currentOr] += dp[i+1][j];
                }
            }
        }

        return dp[0][maxOr];
    }
}


//     3 1

// 0.  0 0
// 1.  0 0
// 2.  0 0
// 3.  1 2



// dp[i][maxXor] denotes count of maxXor at ending at index i

// go over ever maxXor at x-1, increment resultant xor count at i


// maxXor starting at index i = Max of ( maxXor from i+1 ) | nums[i] and ( maxXor from i+1 ) 

// maxXor at n-1 = nums[n-1]




// 0000
// 0001
// 0010
// 0011
// 0100
// ...



// f(0)
//     f(1,[0])
//         f(2,[0,1])
//             f(3)
//             f(3)
//         f(2)
//             f(3)
//             f(3)
//     f(1, [])
//         f(2, [1])
//             f(3)
//             f(3)
//         f(2, [])
//             f(3)
//             f(3)