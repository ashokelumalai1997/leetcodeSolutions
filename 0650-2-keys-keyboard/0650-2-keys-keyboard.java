class Solution {
    public int minSteps(int n) {
        int d = 2;
        int res = 0;
        while(n > 1) {
            while(n%d == 0) {
                res += d;
                n /= d;
            }
            d++;
        }
        return res;
    }
}