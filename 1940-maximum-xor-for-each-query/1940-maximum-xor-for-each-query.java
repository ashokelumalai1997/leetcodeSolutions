class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        /*
        have a result array of length n

start from num[0] and go till num[n-1], at each step gather prefixXOR
    traverse maxBits and store inverse of current XOR in n-1-i pos of res



    [2,3,4,7] 3
    010

        */

        int n = nums.length;
        int[] res = new int[n];

        int xor = 0;
        for(int i = 0; i < n; i ++) {
            xor ^= nums[i];
            int k = 0;
            for(int j = 0; j < maximumBit; j++) {
                if((xor&(1 << j)) == 0) {
                    k |= (1 << j);
                }
            }
            res[n-1-i] = k;
        }

        return res;
    }
}


// XOR

// 1 0 -> 1
// 0 1 -> 1
// 0 0 -> 0
// 1 1 -> 0

// 1 0 1 0 1 0 1

// 0 1 0 1 0 1 0

// 0000000000000
// 0000000000001
// 0000000000001
// 0000000000011


// have a result array of length n

// start from num[0] and go till num[n-1], at each step gather prefixXOR
//     traverse maxBits and store inverse of current XOR in n-1-i pos of res
