class Solution {
    public int minBitFlips(int start, int goal) {
        int t = 0;
        int res = 0;
        while(t < 31) {
            if(((1 << t)&start) != ((1 << t)&goal)) res++;
            t++;
        }
        return res;
    }
}