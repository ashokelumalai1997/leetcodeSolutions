class Solution {
    public long minEnd(int n, int x) {
        long res = x;
        int i = 1;
        while(i < n) {
            res++;
            res |= x;
            i++;
        }
        return res;
    }
}


// 1 0 0 1
// 1 0 1 0

// 1 0 1 1