/*

current =
num+
(
num - 1 - how many? +
num + 1 - how many?
)*num

overall += current



return overall

*/

class Solution {
    public int sumOfGoodSubsequences(int[] nums) {
        long[] counts = new long[100100];
        long overall = 0;
        long[] total = new long[100100];
        for(int num : nums) {
            counts[num+1] += (counts[num] + counts[num+2] + 1)%1000000007;
            long current = (1 + counts[num] + counts[num+2])*num*1l%1000000007;
            current += (total[num] + total[num+2])%1000000007;
            total[num+1] = (total[num+1] + current)%1000000007;
            overall = (overall + current)%1000000007;
        }

        return (int)(overall%1000000007);
    }
}

// 1,2,1

// 1

// 2 - 1,2

// 1 - 2,1 - 1,2,1

// total[1] = 8;
// count[1] = 2;
// count[2] = 1
// total[2] = 5



