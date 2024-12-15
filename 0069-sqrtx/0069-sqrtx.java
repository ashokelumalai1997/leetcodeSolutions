class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int t = 1;

        int re = t;

        while(t <= x/t) {
            re = t;
            t++;
        }

        return re;

    }
}