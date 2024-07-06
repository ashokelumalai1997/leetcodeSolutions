class Solution {
    public int passThePillow(int n, int time) {
        time %= 2*(n - 1);
        time++;
        return (time <= n - 1) ? (time) : (2*n - time);
    }
}